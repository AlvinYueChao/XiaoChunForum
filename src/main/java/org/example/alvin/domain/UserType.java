package org.example.alvin.domain;

import lombok.Getter;

public enum UserType {
    COMMON_USER(1),
    ADMIN_USER(2);

    @Getter
    private final int value;

    private UserType(int value) {
        this.value = value;
    }
}
