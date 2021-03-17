package com.salareunios.api.mapper;

import com.salareunios.api.dto.RoomDto;
import com.salareunios.api.model.Room;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-02T14:37:32-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
)
public class RoomMapperImpl implements RoomMapper {

    @Override
    public Room toModel(RoomDto personDto) {
        if ( personDto == null ) {
            return null;
        }

        Room room = new Room();

        if ( personDto.getDate() != null ) {
            room.setDate( LocalDate.parse( personDto.getDate(), DateTimeFormatter.ofPattern( "dd/MM/yyyy" ) ) );
        }
        room.setId( personDto.getId() );
        room.setName( personDto.getName() );
        room.setStartHour( personDto.getStartHour() );
        room.setEndHour( personDto.getEndHour() );

        return room;
    }

    @Override
    public RoomDto toDto(Room person) {
        if ( person == null ) {
            return null;
        }

        RoomDto roomDto = new RoomDto();

        roomDto.setId( person.getId() );
        roomDto.setName( person.getName() );
        if ( person.getDate() != null ) {
            roomDto.setDate( DateTimeFormatter.ISO_LOCAL_DATE.format( person.getDate() ) );
        }
        roomDto.setStartHour( person.getStartHour() );
        roomDto.setEndHour( person.getEndHour() );

        return roomDto;
    }
}
