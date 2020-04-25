package org.example.alvin.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MethodPerformance {
    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance() {
        this.end = System.currentTimeMillis();
        long elapse = this.end - this.begin;
        log.info("{} 花费 {} 毫秒.", this.serviceMethod, elapse);
    }
}
