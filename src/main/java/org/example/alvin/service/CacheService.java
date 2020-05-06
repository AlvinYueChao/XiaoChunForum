package org.example.alvin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheService {
    private final RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    public CacheService(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void add(String key, String field, String value) {

    }

    public void deleteField(String key, String field) {

    }

    public void deleteAll(String key) {

    }

    public void update(String key, String field, String currentValue, String newValue) {

    }

    public Object getField(String key, String field) {
        return null;
    }

    public Map<Object, Object> getAll(String key) {
        return new HashMap<>();
    }
}
