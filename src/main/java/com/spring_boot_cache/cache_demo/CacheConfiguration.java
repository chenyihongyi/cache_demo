package com.spring_boot_cache.cache_demo;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/1/13 21:38
 */
@Configuration
@EnableCaching
public class CacheConfiguration {

    @Bean
    public CacheManager simpleCacheManager() {

        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

        ConcurrentMapCache cache = new ConcurrentMapCache("cache-1");

        ConcurrentMapCache personsCache = new ConcurrentMapCache("persons");

        simpleCacheManager.setCaches(Arrays.asList(cache, personsCache));

        return simpleCacheManager;

    }
}
