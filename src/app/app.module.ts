import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RecordingStudioListComponent } from './components/recording-studio-list/recording-studio-list.component';
import {HttpClientModule} from "@angular/common/http";
import { CreateRecordingStudioComponent } from './components/create-recording-studio/create-recording-studio.component';
import {FormsModule} from "@angular/forms";
import { CreateArtistComponent } from './components/create-artist/create-artist.component';
import { UpdateRecordingStudioDialogComponent } from './components/update-recording-studio-dialog/update-recording-studio-dialog.component';
import {MatButton} from "@angular/material/button";
import { ShowArtistsDialogComponent } from './components/show-artists-dialog/show-artists-dialog.component';
import { UpdateArtistDialogComponent } from './components/update-artist-dialog/update-artist-dialog.component';


@NgModule({
  declarations: [
    AppComponent,
    RecordingStudioListComponent,
    CreateRecordingStudioComponent,
    CreateArtistComponent,
    UpdateRecordingStudioDialogComponent,
    ShowArtistsDialogComponent,
    UpdateArtistDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatButton
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
