import {Component, OnDestroy, OnInit} from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { UpdateRecordingStudioDialogComponent } from '../update-recording-studio-dialog/update-recording-studio-dialog.component';
import { RecordingStudio } from "../../../models/recording-studio";
import { RecordingStudioService } from "../../../services/recording-studio.service";
import { clearAllBodyScrollLocks, disableBodyScroll, enableBodyScroll } from 'body-scroll-lock';
import { CreateArtistComponent } from "../../artist-components/create-artist/create-artist.component";
import {ShowArtistsDialogComponent} from "../show-artists-dialog/show-artists-dialog.component";
import {
  CreateRecordingStudioDialogComponent
} from "../create-recording-studio-dialog/create-recording-studio-dialog.component";
import {ShowAllArtistsDialogComponent} from "../show-all-artists-dialog/show-all-artists-dialog.component";
import {ArtistService} from "../../../services/artist.service";
import {Artist} from "../../../models/artist";

@Component({
  selector: 'app-recording-studio-list',
  templateUrl: './recording-studio-list.component.html',
  styleUrls: ['./recording-studio-list.component.css']
})
export class RecordingStudioListComponent implements OnInit, OnDestroy {

  recordingStudios: RecordingStudio[] = [];
  artists: Artist[] = [];

  constructor(
    private recordingStudioService: RecordingStudioService,
    private artistService: ArtistService,
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
      data.sort((a, b) => {
        const nameA = a?.studioName?.toLowerCase();
        const nameB = b?.studioName?.toLowerCase();

        if (nameA && nameB) {
          if (nameA < nameB) {
            return -1;
          }
          if (nameA > nameB) {
            return 1;
          }
        }

        return 0;
      });
      this.recordingStudios = data;
    });
  }

  public openAddRecordingStudioDialog(){

    const targetElement = document.querySelector('body')!;
    disableBodyScroll(targetElement); // Блокировать прокрутку

    const dialogRef = this.dialog.open(CreateRecordingStudioDialogComponent, {
      width: '500px',
      disableClose: true
    });
    dialogRef.afterClosed().subscribe(() => {
      enableBodyScroll(targetElement);
      this.getRecordingStudios();
    });
  }

  deleteRecordingStudio(id: number | undefined) {
    this.recordingStudioService.deleteRecordingStudio(id).subscribe(data => {
      console.log(data);
      this.getRecordingStudios();
    });
  }

  showAllArtist(recordingStudio : RecordingStudio) {

    if (recordingStudio.id !== undefined) {
      this.artistService.getArtistsList().subscribe(data => {
        this.artists = data;

        const targetElement = document.querySelector('body')!;
        disableBodyScroll(targetElement);

        const dialogRef = this.dialog.open(ShowAllArtistsDialogComponent, {
          width: '500px',
          data: {
            artists: this.artists,
            recordingStudio: recordingStudio
          },
          disableClose: true
        });

        dialogRef.afterClosed().subscribe(() => {
          enableBodyScroll(targetElement); // Разблокировать прокрутку
        });

      });
    }
  }


  showArtists(recordingStudio : RecordingStudio) {

    if (recordingStudio.id !== undefined) {


        const targetElement = document.querySelector('body')!;
        disableBodyScroll(targetElement);

        const dialogRef = this.dialog.open(ShowArtistsDialogComponent, {
          width: '500px',
          data: {
            recordingStudio: recordingStudio
          },
          disableClose: true
        });

        dialogRef.afterClosed().subscribe(() => {
          enableBodyScroll(targetElement); // Разблокировать прокрутку
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
