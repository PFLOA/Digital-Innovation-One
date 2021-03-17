import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { MeetingRoom } from 'src/app/shared/models/room-models/meeting-room';
import { RoomService } from '../../services/room.service';


@Component({
  selector: 'pf-create-room',
  templateUrl: './create-room.component.html',
  styleUrls: ['./create-room.component.scss']
})
export class CreateRoomComponent implements OnInit {

  room: MeetingRoom = new MeetingRoom();
  submmited: boolean = false;

  constructor(private roomService: RoomService, private router: Router) { }

  ngOnInit(): void {
  }

  newRoom(): void {
    this.room = new MeetingRoom();
    this.submmited = false;
  }

  saveNewRoom(): void {
    console.log(this.room);
    this.roomService.createRoom(this.room).subscribe(
      data => console.log(data),
      error => console.error(error)
    );

    this.submmited = false;
    this.room = new MeetingRoom();

    this.goToList();
  }

  onSubmit(): void {
    this.submmited = true;
  }

  goToList(): void {
    this.router.navigate(['/rooms']);
  }

}
