package org.example.alvin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.persistence.EntityManagerFactory;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class BaseDao<T> {

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public BaseDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public Page<T> pagedQuery(@NotNull String hql, @Min(value = 1, message = "pageNo should start from 1") int pageNo, int pageSize, Object... values) {
        String countQueryString = String.format(" SELECT COUNT(*) %s", removeSelect(removeOrders(hql))) ;

        return null;
    }

    public Query createQuery(@NotNull String hql, Object... values) {
        return null;
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
