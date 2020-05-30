package org.example.alvin.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class LoginLog extends BaseDomain {
    private Long loginLogId;
    private Long userId;
    private String ip;
    private Date loginDate;
}
