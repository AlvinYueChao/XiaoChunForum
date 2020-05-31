package org.example.alvin.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.OffsetDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_topic")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Topic extends BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private int topicId;

    @Column(name = "board_id")
    private int boardId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "topic_title")
    private String topicTitle;

    @Column(name = "create_time")
    private OffsetDateTime createTime;

    @Column(name = "last_post")
    private OffsetDateTime lastPost;

    @Column(name = "topic_views")
    private int topicViews;

    @Column(name = "topic_replies")
    private int topicReplies;

    @Column(name = "digest")
    private int digest;
}
