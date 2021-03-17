package com.people.manager.api.demo.repository;

import com.people.manager.api.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
