﻿package org.example.alvin.yue.alvin.forum.domain;

import lombok.Data;

import java.util.Date;

@Data
public class LoginLog {
    private int loginLogId;
    private int userId;
    private String ip;
    private Date loginDate;
}
