package org.example.alvin.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PerformanceMonitor {
    private static ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<>();

    public static void begin(String method) {
        log.info("begin monitor...");
        MethodPerformance methodPerformance = new MethodPerformance(method);
        performanceRecord.set(methodPerformance);
    }

    public static void end() {
        log.info("end monitor...");
        MethodPerformance methodPerformance = performanceRecord.get();
        methodPerformance.printPerformance();
    }
}
