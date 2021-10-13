package com.spring.aop.logging.controller;

import com.spring.aop.logging.entity.Person;
import com.spring.aop.logging.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/create")
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @GetMapping("/getPersonBy/{firstName}")
    public Person getPersonBy(@PathVariable String firstName) {
        return personService.getPersonBy(firstName);
    }

    @GetMapping("/getAllPerson")
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @PutMapping("/update")
    public Person updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable String id) {
        return personService.deletePerson(id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllPerson() {
        return personService.deleteAllPerson();
    }

}
