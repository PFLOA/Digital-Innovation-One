import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { CreateRoomComponent } from './pages/meeting-room/containers/create/create-room.component';
import { RoomDetailsComponent } from './pages/meeting-room/containers/details/room-details.component';
import { UpdateRoomComponent } from './pages/meeting-room/containers/update/update-room.component';
import { RoomListComponent } from './pages/meeting-room/home/components/room-list/room-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'rooms', pathMatch: 'full' },
  { path: 'rooms', component: RoomListComponent},
  { path: 'create', component: CreateRoomComponent },
  { path: 'update/:id', component: UpdateRoomComponent },
  { path: 'details/:id', component: RoomDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }