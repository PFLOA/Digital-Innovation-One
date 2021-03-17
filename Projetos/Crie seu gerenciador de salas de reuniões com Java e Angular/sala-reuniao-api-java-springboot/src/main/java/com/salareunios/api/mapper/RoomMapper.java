package com.salareunios.api.mapper;

import com.salareunios.api.dto.RoomDto;
import com.salareunios.api.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    @Mapping(target = "date", source = "date", dateFormat = "dd/MM/yyyy")
    Room toModel(RoomDto personDto);

    RoomDto toDto(Room person);
}
