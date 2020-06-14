package org.example.alvin.dao;

import lombok.extern.slf4j.Slf4j;
import org.example.alvin.domain.Topic;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class TopicDao extends BaseDao<Topic> {
    private static final String GET_BOARD_DIGEST_TOPICS = " SELECT * FROM t_topic WHERE board_id = ? AND digest > 0 ORDER BY last_post DESC, digest desc ";
    private static final String GET_PAGED_TOPICS = " SELECT * FROM t_topic WHERE board_id = ? ORDER BY last_post DESC ";
    private static final String QUERY_TOPIC_BY_TITLE = " SELECT * FROM t_topic WHERE topic_title like ? ORDER BY last_post DESC ";

    /**
     * 获取论坛版块某一页的精华主题帖，按最后回复时间以及精华级别 降序排列
     * @param boardId 论坛版块ID
     * @param pageNo 该页起始下标
     * @param pageSize 页大小
     * @return 该页所有精华主题帖
     */
    public Page<Topic> getBoardDigestTopics(int boardId, int pageNo, int pageSize) {
        return pagedQuery(GET_BOARD_DIGEST_TOPICS, pageNo, pageSize, boardId);
    }

    /**
     * 获取论坛版块分页的主题帖子
     * @param boardId 论坛版块ID
     * @param pageNo 页号，从1开始
     * @param pageSize 页大小
     * @return 包含分页信息的Page对象
     */
    public Page<Topic> getPagedTopics(int boardId, int pageNo, int pageSize) {
        return pagedQuery(GET_PAGED_TOPICS, pageNo, pageSize, boardId);
    }

    /**
     * 根据主题帖标题查询所有模糊匹配的主题帖
     * @param title 标题的查询条件
     * @param pageNo 页号，从1开始
     * @param pageSize 每页的记录数
     * @return 包含分页信息的Page对象
     */
    public Page<Topic> queryTopicByTitle(String title, int pageNo, int pageSize) {
        return pagedQuery(QUERY_TOPIC_BY_TITLE, pageNo, pageSize, title);
    }
}
