package com.people.manager.api.demo.controller;


import com.people.manager.api.demo.dto.request.PersonDto;
import com.people.manager.api.demo.dto.response.MessageResponseDto;
import com.people.manager.api.demo.entity.Person;
import com.people.manager.api.demo.exceptions.PersonNotFoundException;
import com.people.manager.api.demo.repository.PersonRepository;
import com.people.manager.api.demo.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto postPerson(@RequestBody @Valid PersonDto personDto){
       return personService.postPerson(personDto);
    }

    @GetMapping
    public List<PersonDto> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDto findById(@PathVariable long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable long id) throws PersonNotFoundException {
        personService.deletePerson(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDto updateById(@PathVariable long id, @RequestBody PersonDto personDto) throws PersonNotFoundException {
        return personService.updatePerson(id,personDto);
    }
}
