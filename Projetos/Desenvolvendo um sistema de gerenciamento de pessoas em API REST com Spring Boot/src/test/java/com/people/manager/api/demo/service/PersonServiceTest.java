package com.people.manager.api.demo.service;

import com.people.manager.api.demo.dto.request.PersonDto;
import com.people.manager.api.demo.dto.response.MessageResponseDto;
import com.people.manager.api.demo.entity.Person;
import com.people.manager.api.demo.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.people.manager.api.demo.utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDtoThenReturnSavedMessage(){
        PersonDto personDto = createFakeDto();
        Person expectedPersonSaved = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedPersonSaved);

        MessageResponseDto expectedMessage = messageResponseDtoConstructor(expectedPersonSaved.getId());
        MessageResponseDto messageResponseDto = personService.postPerson(personDto);

        assertEquals(expectedMessage, messageResponseDto);
    }

    private MessageResponseDto messageResponseDtoConstructor(long id){
        return MessageResponseDto
                .builder()
                .message("Person created with ID " + id)
                .build();
    }
}
