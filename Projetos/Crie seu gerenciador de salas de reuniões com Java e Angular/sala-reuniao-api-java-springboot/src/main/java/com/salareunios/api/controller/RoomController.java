package com.salareunios.api.controller;

import com.salareunios.api.dto.RoomDto;
import com.salareunios.api.exception.RoomNotFoundException;
import com.salareunios.api.response.MessageResponseDto;
import com.salareunios.api.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("api/v1/rooms")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoomController {

    private RoomService roomService;

    @GetMapping()
    public List<RoomDto> getListOfRooms(){
        return roomService.listAll();
    }

    @GetMapping("/{id}")
    public RoomDto findById(@PathVariable long id) throws RoomNotFoundException {
        return roomService.findRoomById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto postRoom(@RequestBody @Valid RoomDto roomDto){
        return roomService.postRoom(roomDto);
    }

    @PutMapping("/{id}")
    public MessageResponseDto updateById(@PathVariable long id, @RequestBody RoomDto personDto) throws RoomNotFoundException {
        return roomService.updateRoom(id,personDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable long id) throws RoomNotFoundException {
        roomService.deleteRoom(id);
    }

}
