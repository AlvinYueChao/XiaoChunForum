package org.example.alvin.dao;

import org.example.alvin.domain.Post;

public class PostDao extends BaseDao<Post> {
    private static final String GET_PAGED_POSTS = " SELECT * FROM t_post WHERE topic_id = ? ORDER BY create_time DESC ";
    private static final String DELETE_TOPIC_POSTS = " DELETE FROM t_post WHERE topic_id = ? ";

    public Page<Post> getPagedPosts(int topicId, int pageNo, int pageSize) {
         return pagedQuery(GET_PAGED_POSTS, pageNo, pageSize, topicId);
    }

    /**
     * 删除主题下所有帖子
     * @param topicId 主题ID
     */
    public void deleteTopicPosts(int topicId) {
        getJdbcTemplate().update(DELETE_TOPIC_POSTS, topicId);
    }
}
