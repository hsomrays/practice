import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { UpdateRecordingStudioDialogComponent } from '../update-recording-studio-dialog/update-recording-studio-dialog.component';
import { RecordingStudio } from "../../models/recording-studio";
import { RecordingStudioService } from "../../services/recording-studio.service";
import { clearAllBodyScrollLocks, disableBodyScroll, enableBodyScroll } from 'body-scroll-lock';
import { CreateArtistComponent } from "../create-artist/create-artist.component";
import {ShowArtistsDialogComponent} from "../show-artists-dialog/show-artists-dialog.component";

@Component({
  selector: 'app-recording-studio-list',
  templateUrl: './recording-studio-list.component.html',
  styleUrls: ['./recording-studio-list.component.css']
})
export class RecordingStudioListComponent implements OnInit {

  recordingStudios: RecordingStudio[] = [];

  constructor(
    private recordingStudioService: RecordingStudioService,
    private dialog: MatDialog
  ) { }

  ngOnInit() {
    this.getRecordingStudios();
  }

  ngOnDestroy() {
    clearAllBodyScrollLocks();
  }

  private getRecordingStudios() {
    this.recordingStudioService.getRecordingStudiosList().subscribe(data => {
      this.recordingStudios = data;
    });
  }

  deleteRecordingStudio(id: number | undefined) {
    this.recordingStudioService.deleteRecordingStudio(id).subscribe(data => {
      console.log(data);
      this.getRecordingStudios();
    });
  }

  addArtist(recordingStudioId: number | undefined) {
    const targetElement = document.querySelector('body')!;
    disableBodyScroll(targetElement);

    const dialogRef = this.dialog.open(CreateArtistComponent, {
      width: '500px',
      data: recordingStudioId,
      disableClose: true
    });

    dialogRef.afterClosed().subscribe(() => {
      enableBodyScroll(targetElement); // Разблокировать прокрутку
    });
  }


  showArtists(recordingStudio : RecordingStudio) {

    if (recordingStudio.id !== undefined) {
      this.recordingStudioService.getArtistsList(recordingStudio.id).subscribe(data => {
        console.log('Received data:', data);

        const targetElement = document.querySelector('body')!;
        disableBodyScroll(targetElement);

        const dialogRef = this.dialog.open(ShowArtistsDialogComponent, {
          width: '500px',
          data: {
            recordingStudioName: recordingStudio.studioName,
            artists: data,
            recordingStudioId: recordingStudio.id
          },
          disableClose: true
        });

        dialogRef.afterClosed().subscribe(() => {
          enableBodyScroll(targetElement); // Разблокировать прокрутку
        });

      });
    }

  }


  openUpdateRecordingStudioDialog(recordingStudio: RecordingStudio): void {

    const targetElement = document.querySelector('body')!;
    disableBodyScroll(targetElement); // Блокировать прокрутку

    const dialogRef = this.dialog.open(UpdateRecordingStudioDialogComponent, {
      width: '500px',
      data: recordingStudio,
      disableClose: true // Запретить закрытие модального окна по клику вне его
    });

    dialogRef.afterClosed().subscribe(() => {
      enableBodyScroll(targetElement); // Разблокировать прокрутку
    });
  }

}
