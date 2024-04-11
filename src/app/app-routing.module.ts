import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RecordingStudioListComponent} from "./components/recording-studio-components/recording-studio-list/recording-studio-list.component";
import {CreateArtistComponent} from "./components/artist-components/create-artist/create-artist.component";
import {UpdateRecordingStudioDialogComponent} from "./components/recording-studio-components/update-recording-studio-dialog/update-recording-studio-dialog.component";
import {ArtistListComponent} from "./components/artist-components/artist-list/artist-list.component";



const routes: Routes = [
  {path: 'recordingStudios', component: RecordingStudioListComponent},
  {path: 'updateRecordingStudio/:id', component: UpdateRecordingStudioDialogComponent},
  {path: 'createArtist/:recordingStudioId', component: CreateArtistComponent},
  {path: 'artists', component: ArtistListComponent},
  {path: '', redirectTo: 'recordingStudios', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
