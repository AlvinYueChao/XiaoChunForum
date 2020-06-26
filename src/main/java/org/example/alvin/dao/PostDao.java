package org.example.alvin.dao;

import org.example.alvin.domain.Post;
import org.example.alvin.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao extends BaseDao<Post> {
    private static final String GET_PAGED_POSTS = " SELECT * FROM t_post WHERE topic_id = ? ORDER BY create_time DESC ";

    private PostRepository postRepository;

    @Autowired
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<Post> getPagedPosts(int topicId, int pageNo, int pageSize) {
         return pagedQuery(GET_PAGED_POSTS, pageNo, pageSize, topicId);
    }

    /**
     * 删除主题下所有帖子
     * @param topicId 主题ID
     */
    public void deleteTopicPosts(int topicId) {
        this.postRepository.deleteByPostId(topicId);
    }
}
