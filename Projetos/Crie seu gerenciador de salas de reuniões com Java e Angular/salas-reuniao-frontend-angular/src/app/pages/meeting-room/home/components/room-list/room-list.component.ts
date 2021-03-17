import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router'

import { RoomService } from 'src/app/pages/meeting-room/services/room.service';
import { MeetingRoom } from 'src/app/shared/models/room-models/meeting-room';

@Component({
  selector: 'pf-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.scss']
})
export class RoomListComponent implements OnInit {

  public rooms: MeetingRoom[];

  constructor(private roomService: RoomService,
    private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.roomService.getRoomList().subscribe((rooms: MeetingRoom[]) => {
      this.rooms = rooms;
      console.log(this.rooms);
    });
  }

  deleteRoom(id: number) {
    this.roomService.deleteRoom(id)
      .subscribe(data => {
        console.log('ID Saved data');
        this.reloadData();
      },
        error => console.error(error)
      );
  }

  detailsRoom(id: number) {
    this.router.navigate(['details', id]);
  }

  updateRoom(id: number) {
    this.router.navigate(['update', id]);
  }
}
