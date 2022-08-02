package com.example.myrabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myrabbitmq.publisher.service.PersonService;
import com.example.myrabbitmq.schema.Person;



@RestController
@RequestMapping("person")
public class PersonController {
    
    @Autowired
    private PersonService personService;

    @PostMapping(value="")
    public void createPerson(@RequestBody Person person) {
        personService.createPerson(person);
    }
    
    @PutMapping(value="")
    public void updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
    }
}
