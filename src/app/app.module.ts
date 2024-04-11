import {Injectable, NgModule} from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RecordingStudioListComponent } from './components/recording-studio-components/recording-studio-list/recording-studio-list.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { CreateArtistComponent } from './components/artist-components/create-artist/create-artist.component';
import { UpdateRecordingStudioDialogComponent } from './components/recording-studio-components/update-recording-studio-dialog/update-recording-studio-dialog.component';
import {MatButton} from "@angular/material/button";
import { ShowArtistsDialogComponent } from './components/recording-studio-components/show-artists-dialog/show-artists-dialog.component';
import { UpdateArtistDialogComponent } from './components/artist-components/update-artist-dialog/update-artist-dialog.component';
import { CreateRecordingStudioDialogComponent } from './components/recording-studio-components/create-recording-studio-dialog/create-recording-studio-dialog.component';
import { ArtistListComponent } from './components/artist-components/artist-list/artist-list.component';
import { ShowAllArtistsDialogComponent } from './components/recording-studio-components/show-all-artists-dialog/show-all-artists-dialog.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { ENVIRONMENT, EnvironmentService } from './services/environment.service';
import {environment} from "../environments/environment";


@Injectable({
  providedIn: 'root',
})



@NgModule({
  declarations: [
    AppComponent,
    RecordingStudioListComponent,
    CreateArtistComponent,
    UpdateRecordingStudioDialogComponent,
    ShowArtistsDialogComponent,
    UpdateArtistDialogComponent,
    CreateRecordingStudioDialogComponent,
    ArtistListComponent,
    ShowAllArtistsDialogComponent
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatButton
  ],
  providers: [
    { provide: ENVIRONMENT, useValue: environment},
    EnvironmentService,
    provideClientHydration()
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
