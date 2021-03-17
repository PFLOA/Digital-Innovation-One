package com.salareunios.api.service;

import com.salareunios.api.dto.RoomDto;
import com.salareunios.api.exception.RoomNotFoundException;
import com.salareunios.api.mapper.RoomMapper;
import com.salareunios.api.model.Room;
import com.salareunios.api.repository.RoomRepository;
import com.salareunios.api.response.MessageResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoomService {

    private RoomRepository roomRepository;
    private final RoomMapper roomMapper = RoomMapper.INSTANCE;

    //Obtem a lista dois itens no banco de dados.
    public List<RoomDto> listAll() {
        List<Room> allRoom = roomRepository.findAll();

        return allRoom.stream()
                .map(roomMapper::toDto)
                .collect(Collectors.toList());
    }

    public RoomDto findRoomById(long id) throws RoomNotFoundException {
        Room room = verifyIfExists(id);
        return roomMapper.toDto(room);
    }

    public MessageResponseDto postRoom(RoomDto roomDto) {
        Room toSaveRoom = roomMapper.toModel(roomDto);
        Room savedRoom = roomRepository.save(toSaveRoom);
        return createMessageResponse(savedRoom.getId(), "Room been saved with ID:");
    }

    public MessageResponseDto updateRoom(long id, RoomDto personDto) throws RoomNotFoundException {
        verifyIfExists(id);

        Room personToUpdate = roomMapper.toModel(personDto);
        Room updatePerson = roomRepository.save(personToUpdate);

        return createMessageResponse(updatePerson.getId(), "Success to update room with ID");
    }

    public void deleteRoom(long id) throws RoomNotFoundException {
        verifyIfExists(id);
        roomRepository.deleteById(id);
    }

    private Room verifyIfExists(long id) throws RoomNotFoundException {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }

    private MessageResponseDto createMessageResponse(long id, String message){
        return MessageResponseDto
                .builder()
                .message(message+" "+id)
                .build();
    }
}
