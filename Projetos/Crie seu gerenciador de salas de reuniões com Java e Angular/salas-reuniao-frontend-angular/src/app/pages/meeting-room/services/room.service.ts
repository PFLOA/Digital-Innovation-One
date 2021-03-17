import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MeetingRoom } from 'src/app/shared/models/room-models/meeting-room';

@Injectable({
  providedIn: 'root'
})

export class RoomService {

  private baseUrl: string = 'http://localhost:8087/api/v1/rooms';

  constructor(private http: HttpClient) { }

  getRoomById(id: number): Observable<MeetingRoom> {
    return this.http.get<MeetingRoom>(`${this.baseUrl}/${id}`);
  }

  getRoomList(): Observable<MeetingRoom[]> {
    return this.http.get<MeetingRoom[]>(`${this.baseUrl}`);
  }

  deleteRoom(id: number): Observable<MeetingRoom> {
    return this.http.delete<MeetingRoom>(`${this.baseUrl}/${id}`);;
  }

  updateRoom(id: number, room: MeetingRoom): Observable<MeetingRoom> {
    console.log("Id atualização" + id);
    return this.http.put<MeetingRoom>(`${this.baseUrl}/${id}`, room);
  }

  createRoom(room: MeetingRoom): Observable<MeetingRoom> {
    return this.http.post<MeetingRoom>(`${this.baseUrl}`, room);
  }

}
