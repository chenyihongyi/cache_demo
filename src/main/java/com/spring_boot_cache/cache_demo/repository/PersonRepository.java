package com.spring_boot_cache.cache_demo.repository;

import com.spring_boot_cache.cache_demo.entity.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/1/13 22:20
 */
@NoRepositoryBean
public interface PersonRepository {

    @Cacheable(cacheNames = "persons")
    Person findPerson(String id);

    boolean savePerson(Person person);
}
