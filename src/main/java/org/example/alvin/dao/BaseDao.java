package org.example.alvin.dao;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.persistence.EntityManagerFactory;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Repository
public class BaseDao<T> {

    private final EntityManagerFactory entityManagerFactory;
    private final JdbcTemplate jdbcTemplate;
    private final Class<T> entityClass;

    @Autowired
    public BaseDao(EntityManagerFactory entityManagerFactory, JdbcTemplate jdbcTemplate) {
        this.entityManagerFactory = entityManagerFactory;
        this.jdbcTemplate = jdbcTemplate;

        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        this.entityClass = (Class) params[0];
    }

    public Page<T> pagedQuery(@NotNull String hql, @Min(value = 1, message = "pageNo should start from 1") int pageNo, int pageSize, Object... values) {
        String countQueryString = String.format(" SELECT COUNT(*) %s", removeSelect(removeOrders(hql))) ;
        Integer resultRowCount = 0;
        try {
            resultRowCount = this.jdbcTemplate.query(countQueryString, resultSet -> {
                int count = 0;
                if (resultSet.next()) {
                    count = resultSet.getInt(0);
                }
                return count;
            });
        } catch (DataAccessException e) {
            log.error("{}: Exception in paged query", this.getClass().getName(), e);
        }
        if (resultRowCount == null || resultRowCount < 1) {
            return new Page<>();
        }
        int startIndex = Page.getStartOfPage(pageNo, pageSize);
        Query<T> query = createQuery(hql, values);
        List<T> list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();
        return new Page<>(startIndex, resultRowCount, pageSize, list);
    }

    public Query<T> createQuery(@NotNull String hql, Object... values) {
        Query<T> query = getSession().createQuery(hql, entityClass);
        for (int i = 0; i < values.length; i++) {
            query.setParameter(i, values[i]);
        }
        return query;
    }

    private static String removeSelect(@NotNull String hql) {
        int beginPos = hql.toLowerCase().indexOf("from");
        Assert.isTrue(beginPos != -1, String.format("hql: %s must has a keyword 'from'", hql));
        return hql.substring(beginPos);
    }

    /**
     * order by 及之后的所有语句都将被清除
     * @param hql 用户输入的 query 语句
     * @return 去除 order by 语句之后的 query
     */
    private static String removeOrders(@NotNull String hql) {
        Pattern pattern = Pattern.compile("order\\s*by[\\s|\\S]*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hql);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "");
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    protected Session getSession() {
        return this.entityManagerFactory.unwrap(SessionFactory.class).getCurrentSession();
    }
}
