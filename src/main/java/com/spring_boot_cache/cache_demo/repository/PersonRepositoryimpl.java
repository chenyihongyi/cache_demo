package com.spring_boot_cache.cache_demo.repository;

import com.spring_boot_cache.cache_demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/1/13 22:33
 */
@Repository
public class PersonRepositoryimpl implements PersonRepository{

    private final Map<String, Person> repository = new HashMap<>();

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Person findPerson(String id) {
        return (Person) redisTemplate.opsForValue().get(id);
    }

    @Override
    public boolean savePerson(Person person) {
        redisTemplate.opsForValue().set(person.getId(), person);
        return true;
    }
}
