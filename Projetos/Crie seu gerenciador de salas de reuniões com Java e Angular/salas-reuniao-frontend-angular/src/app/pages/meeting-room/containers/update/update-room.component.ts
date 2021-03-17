import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MeetingRoom } from 'src/app/shared/models/room-models/meeting-room';
import { RoomService } from '../../services/room.service';


@Component({
  selector: 'pf-update-room',
  templateUrl: './update-room.component.html',
  styleUrls: ['./update-room.component.scss']
})
export class UpdateRoomComponent implements OnInit {

  id: number;
  room: MeetingRoom;
  submmited: boolean = false;

  constructor(private roomService: RoomService, private route: Router, private activateRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.room = new MeetingRoom();
    this.id = this.activateRoute.snapshot.params['id'];

    this.roomService.getRoomById(this.id)
      .subscribe(data => {
        console.log(data);
        this.room = data;
      },
        error => console.error(error)
      );
  }

  updateRoom() {
    this.roomService.updateRoom(this.id, this.room)
      .subscribe(data => console.log(data),
        error => console.error(error)
        );

    this.room = new MeetingRoom();
    this.goToList();
  }

  onSubmit(){
    this.updateRoom();
  }

  goToList() {
    this.route.navigate(['/rooms']);
  }

}
