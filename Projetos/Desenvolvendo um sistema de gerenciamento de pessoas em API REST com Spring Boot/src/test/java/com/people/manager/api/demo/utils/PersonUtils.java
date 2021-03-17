package com.people.manager.api.demo.utils;

import com.people.manager.api.demo.dto.request.PersonDto;
import com.people.manager.api.demo.entity.Person;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static  final String FIRST_NAME = "Paulo";
    private static  final String LAST_NAME = "Fernando";
    private static  final String CPF_NUMBER = "44415935715";
    private static  final long PERSON_ID = 1L;
    public  static final LocalDate BIRTH_DATE = LocalDate.of(2010, 07,05);

    public static PersonDto createFakeDto(){
        return PersonDto.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("05-07-1995")
                .phones(Collections.singletonList(PhoneUtils.createFakeDto()))
                .build();
    }

    public static Person createFakeEntity(){
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
