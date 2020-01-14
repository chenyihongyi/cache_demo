package com.spring_boot_cache.cache_demo.controller;

import com.spring_boot_cache.cache_demo.entity.Person;
import com.spring_boot_cache.cache_demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/1/13 22:59
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @PostMapping("/save")
    public Person save(@RequestBody Person person) {

        repository.savePerson(person);

        return person;
    }

    @GetMapping("/get/{id}")
    public Person get(@PathVariable String id){
        return repository.findPerson(id);
    }




}
