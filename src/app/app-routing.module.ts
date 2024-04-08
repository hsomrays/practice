import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RecordingStudioListComponent} from "./components/recording-studio-list/recording-studio-list.component";
import {CreateRecordingStudioComponent} from "./components/create-recording-studio/create-recording-studio.component";
import {CreateArtistComponent} from "./components/create-artist/create-artist.component";
import {
  UpdateRecordingStudioDialogComponent
} from "./components/update-recording-studio-dialog/update-recording-studio-dialog.component";

const routes: Routes = [
  {path: 'recordingStudios', component: RecordingStudioListComponent},
  {path: 'createRecordingStudio', component: CreateRecordingStudioComponent},
  {path: 'updateRecordingStudio/:id', component: UpdateRecordingStudioDialogComponent},
  {path: 'createArtist/:recordingStudioId', component: CreateArtistComponent},
  {path: '', redirectTo: 'recordingStudios', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
