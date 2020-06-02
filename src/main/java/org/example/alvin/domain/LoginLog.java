package org.example.alvin.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_login_log")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class LoginLog extends BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_log_id")
    private int loginLogId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "ip")
    private String ip;

    @Column(name = "login_datetime")
    private OffsetDateTime loginDate;
}
