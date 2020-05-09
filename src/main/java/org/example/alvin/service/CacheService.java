package org.example.alvin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CacheService {
    private final RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    public CacheService(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void addOrUpdate(String key, Map<String, String> fieldValuePairs) {

    }

    public void deleteFields(String key, List<String> fields) {

    }

    public void deleteAll(String key) {

    }

    public Map<String, String> getFields(String key, List<String> fields) {
        return null;
    }

    public Map<String, String> getAll(String key) {
        return new HashMap<>();
    }
}
