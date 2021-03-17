import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app.routing.module';
import { AppComponent } from './app.component';

import { AppBootstrapModule } from './app-bootstrap/app-bootstrap.module';

import { MainHeaderComponent } from './shared/components/main-header/main-header.component';
import { LoaderComponent } from './shared/components/loader/loader.component';
import { RoomDetailsComponent } from './pages/meeting-room/containers/details/room-details.component';
import { RoomListComponent } from './pages/meeting-room/home/components/room-list/room-list.component';
import { UpdateRoomComponent } from './pages/meeting-room/containers/update/update-room.component';
import { CreateRoomComponent } from './pages/meeting-room/containers/create/create-room.component';
import { RoomService } from './pages/meeting-room/services/room.service';


@NgModule({
  declarations: [
    AppComponent,
    RoomDetailsComponent,
    RoomListComponent,
    UpdateRoomComponent,
    CreateRoomComponent,
    MainHeaderComponent,
    LoaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [RoomService],
  bootstrap: [AppComponent]
})
export class AppModule { }
