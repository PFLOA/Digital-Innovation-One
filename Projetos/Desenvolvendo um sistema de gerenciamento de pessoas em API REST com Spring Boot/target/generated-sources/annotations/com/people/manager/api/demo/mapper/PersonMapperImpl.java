package com.people.manager.api.demo.mapper;

import com.people.manager.api.demo.dto.request.PersonDto;
import com.people.manager.api.demo.dto.request.PhoneDto;
import com.people.manager.api.demo.dto.request.PhoneDto.PhoneDtoBuilder;
import com.people.manager.api.demo.entity.Person;
import com.people.manager.api.demo.entity.Person.PersonBuilder;
import com.people.manager.api.demo.entity.Phone;
import com.people.manager.api.demo.entity.Phone.PhoneBuilder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-26T15:58:19-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toModel(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }

        PersonBuilder person = Person.builder();

        if ( personDto.getBirthDate() != null ) {
            person.birthDate( LocalDate.parse( personDto.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        person.id( personDto.getId() );
        person.firstName( personDto.getFirstName() );
        person.lastName( personDto.getLastName() );
        person.cpf( personDto.getCpf() );
        person.phones( phoneDtoListToPhoneList( personDto.getPhones() ) );

        return person.build();
    }

    @Override
    public PersonDto toDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDto personDto = new PersonDto();

        personDto.setId( person.getId() );
        personDto.setFirstName( person.getFirstName() );
        personDto.setLastName( person.getLastName() );
        personDto.setCpf( person.getCpf() );
        if ( person.getBirthDate() != null ) {
            personDto.setBirthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( person.getBirthDate() ) );
        }
        personDto.setPhones( phoneListToPhoneDtoList( person.getPhones() ) );

        return personDto;
    }

    protected Phone phoneDtoToPhone(PhoneDto phoneDto) {
        if ( phoneDto == null ) {
            return null;
        }

        PhoneBuilder phone = Phone.builder();

        phone.id( phoneDto.getId() );
        phone.type( phoneDto.getType() );
        phone.number( phoneDto.getNumber() );

        return phone.build();
    }

    protected List<Phone> phoneDtoListToPhoneList(List<PhoneDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Phone> list1 = new ArrayList<Phone>( list.size() );
        for ( PhoneDto phoneDto : list ) {
            list1.add( phoneDtoToPhone( phoneDto ) );
        }

        return list1;
    }

    protected PhoneDto phoneToPhoneDto(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDtoBuilder phoneDto = PhoneDto.builder();

        phoneDto.id( phone.getId() );
        phoneDto.type( phone.getType() );
        phoneDto.number( phone.getNumber() );

        return phoneDto.build();
    }

    protected List<PhoneDto> phoneListToPhoneDtoList(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDto> list1 = new ArrayList<PhoneDto>( list.size() );
        for ( Phone phone : list ) {
            list1.add( phoneToPhoneDto( phone ) );
        }

        return list1;
    }
}
