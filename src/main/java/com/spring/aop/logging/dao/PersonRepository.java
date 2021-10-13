package com.spring.aop.logging.dao;


import com.spring.aop.logging.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
	Person findByFirstName(String firstName);
}
