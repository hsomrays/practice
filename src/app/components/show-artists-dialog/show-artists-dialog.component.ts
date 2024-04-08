import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {ArtistService} from "../../services/artist.service";
import {RecordingStudioService} from "../../services/recording-studio.service";
import {RecordingStudio} from "../../models/recording-studio";
import {disableBodyScroll, enableBodyScroll} from "body-scroll-lock";
import {
  UpdateRecordingStudioDialogComponent
} from "../update-recording-studio-dialog/update-recording-studio-dialog.component";
import {Artist} from "../../models/artist";
import {UpdateArtistDialogComponent} from "../update-artist-dialog/update-artist-dialog.component";

@Component({
  selector: 'app-show-artists-dialog',
  templateUrl: './show-artists-dialog.component.html',
  styleUrl: './show-artists-dialog.component.css'
})
export class ShowArtistsDialogComponent {

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    private recordingStudioService: RecordingStudioService,
    private artistService: ArtistService,
    public dialogRef: MatDialogRef<ShowArtistsDialogComponent>,
    private dialog: MatDialog
  ) {
  }

  ngOnInit() {
  }

  ngOnDestroy() {
  }

  cancel() {
    this.dialogRef.close();
  }

  deleteArtist(id: number | undefined, recordingStudioId: number) {
    this.artistService.deleteArtist(id).subscribe(data => {
      console.log(data);
      this.getArtists(recordingStudioId);
    });
  }

  getArtists(recordingStudioId: number){
    this.recordingStudioService.getArtistsList(recordingStudioId).subscribe(data => {
      console.log('Received data:', data);
      this.data.artists = data;
    });
  }

  openUpdateArtistDialog(artist: Artist): void {

    const targetElement = document.querySelector('body')!;
    disableBodyScroll(targetElement); // Блокировать прокрутку

    const dialogRef = this.dialog.open(UpdateArtistDialogComponent, {
      width: '500px',
      data: artist,
      disableClose: true // Запретить закрытие модального окна по клику вне его
    });

    dialogRef.afterClosed().subscribe(() => {
      enableBodyScroll(targetElement); // Разблокировать прокрутку
    });
  }





}
