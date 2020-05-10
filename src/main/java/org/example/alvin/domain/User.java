package org.example.alvin.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Long userId;
    private String userName;
    private String password;
    private Long credits;
    private String lastIp;
    private Date lastVisit;
}
