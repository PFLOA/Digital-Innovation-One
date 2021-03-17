import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { error } from 'protractor';

import { MeetingRoom } from 'src/app/shared/models/room-models/meeting-room';
import { RoomService } from '../../services/room.service';

@Component({
  selector: 'pf-room-details',
  templateUrl: './room-details.component.html',
  styleUrls: ['./room-details.component.scss']
})

export class RoomDetailsComponent implements OnInit {

  id: number;
  room: MeetingRoom;

  constructor(private route: ActivatedRoute, private roomService: RoomService, private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.roomService.getRoomById(this.id)
      .subscribe(data => {
        console.log(data);
        this.room = data;
      },
        error => console.error(error)
    );
  }

  list(): void{
    this.router.navigate(['rooms']);
  }

}
