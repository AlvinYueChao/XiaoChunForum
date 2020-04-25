package org.example.alvin.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ForumServiceImpl implements ForumService {
    @Override
    public void removeTopic(int topicId) {
        PerformanceMonitor.begin("org.example.alvin.proxy.ForumServiceImpl. removeTopic");
        log.info("模拟删除Topic记录: {}", topicId);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PerformanceMonitor.end();
    }

    @Override
    public void removeForum(int forumId) {
        PerformanceMonitor.begin("org.example.alvin.proxy.ForumServiceImpl. removeForum");
        log.info("模拟删除Forum记录: {}", forumId);

        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PerformanceMonitor.end();
    }
}
