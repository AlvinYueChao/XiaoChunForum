package org.example.alvin.domain;

import lombok.Data;

import java.util.Date;

@Data
public class LoginLog {
    private Long loginLogId;
    private Long userId;
    private String ip;
    private Date loginDate;
}
