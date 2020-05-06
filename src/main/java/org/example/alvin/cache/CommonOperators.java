package org.example.alvin.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

public class CommonOperators {
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

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

    public Map<String, Object> getAll(String key) {
        return new HashMap<>();
    }
}
