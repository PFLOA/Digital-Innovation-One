package com.people.manager.api.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception{
    public PersonNotFoundException(long id){
        super("Person with ID "+id+" not found !");
    }
}
