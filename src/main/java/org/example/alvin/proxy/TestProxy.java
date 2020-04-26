package org.example.alvin.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;

@Slf4j
public class TestProxy {
    public static void main(String[] args) {
        log.info("JDK动态代理");
        ForumServiceImpl target = new ForumServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(target);
        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
        proxy.removeForum(10);
        proxy.removeTopic(1012);

        log.info("CGLIB动态代理");
        CglibProxy cglibProxy = new CglibProxy();
        ForumServiceImpl forumService = (ForumServiceImpl) cglibProxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }
}
