package org.example.alvin.domain;

import lombok.Getter;

public enum UserLockStatus {
    USER_UNLOCK(0),
    USER_LOCK(1);

    @Getter
    private final int lockStatus;

    private UserLockStatus(int lockStatus) {
        this.lockStatus = lockStatus;
    }
}
