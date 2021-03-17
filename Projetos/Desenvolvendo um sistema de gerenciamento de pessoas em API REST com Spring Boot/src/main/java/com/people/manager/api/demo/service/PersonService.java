package com.people.manager.api.demo.service;

import com.people.manager.api.demo.dto.request.PersonDto;
import com.people.manager.api.demo.dto.response.MessageResponseDto;
import com.people.manager.api.demo.entity.Person;
import com.people.manager.api.demo.exceptions.PersonNotFoundException;
import com.people.manager.api.demo.mapper.PersonMapper;
import com.people.manager.api.demo.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDto postPerson( PersonDto personDto){
        Person toSavePerson = personMapper.toModel(personDto);

        Person savedPerson = personRepository.save(toSavePerson);
        return MessageResponseDto
                .builder()
                .message("Person created with ID "+savedPerson.getId())
                .build();
    }

    public List<PersonDto> listAll() {
        List<Person> allPerson = personRepository.findAll();
        return allPerson.stream()
                        .map(personMapper::toDto)
                        .collect(Collectors.toList());
    }

    public PersonDto findById(long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);

        return personMapper.toDto(person);
    }

    public void deletePerson(long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDto updatePerson(long id, PersonDto personDto) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDto);
        Person updatePerson = personRepository.save(personToUpdate);

        return createMessageResponse(updatePerson.getId(), "Updated person with ID");
    }

    private Person verifyIfExists(long id) throws PersonNotFoundException {
       return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDto createMessageResponse(long id, String message){
        return MessageResponseDto
                .builder()
                .message(message+" "+id)
                .build();
    }
}
