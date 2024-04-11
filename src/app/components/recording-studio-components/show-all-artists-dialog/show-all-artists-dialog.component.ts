import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {RecordingStudioService} from "../../../services/recording-studio.service";
import {ArtistService} from "../../../services/artist.service";
import {Artist} from "../../../models/artist";
import {clearAllBodyScrollLocks, disableBodyScroll, enableBodyScroll} from "body-scroll-lock";
import {UpdateArtistDialogComponent} from "../../artist-components/update-artist-dialog/update-artist-dialog.component";
import {RecordingStudio} from "../../../models/recording-studio";
import {animate, state, style, transition, trigger} from "@angular/animations";

@Component({
  selector: 'app-show-all-artists-dialog',
  templateUrl: './show-all-artists-dialog.component.html',
  styleUrl: './show-all-artists-dialog.component.css',
  animations: [
    trigger('modalAppear', [
      state('void', style({ opacity: 0})), // начальное состояние до появления
      state('*', style({ opacity: 1})), // состояние после появления
      transition('void => *', animate('300ms ease-in')), // анимация появления
      transition('* => void', animate('300ms ease-out')) // анимация исчезновения
    ])
  ]
})
export class ShowAllArtistsDialogComponent {

  artists: Artist[] = [];
  showErrorDialog: boolean = false;
  errorMessage: string = '';

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    private recordingStudioService: RecordingStudioService,
    private artistService: ArtistService,
    public dialogRef: MatDialogRef<ShowAllArtistsDialogComponent>,
  ) {  }

  ngOnInit(): void {
    this.getArtists();
  }

  ngOnDestroy() {
    clearAllBodyScrollLocks();
  }

  cancel() {
    this.dialogRef.close();
  }

  private getArtists(){
    this.artistService.getArtistsList().subscribe(data => {
      data.sort((a, b) => {
        const nameA = a?.name?.toLowerCase();
        const nameB = b?.name?.toLowerCase();

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
      this.artists = data;
    });
  }

  addArtistToRecordingStudio(artist: Artist, recordingStudio: RecordingStudio): void {
    if (artist && recordingStudio) {
      if (!recordingStudio.artists?.some(a => a.id === artist.id)) {
        recordingStudio.artists?.push(artist);
        console.log(recordingStudio);
        this.recordingStudioService.updateRecordingStudio(recordingStudio).subscribe(data => {
          console.log(data);
          this.getArtists();
        }, error => {
          this.showErrorDialog = true;
          this.errorMessage = "Failed to update recording studio: " + error.message;
        });
      } else {
        this.showErrorDialog = true;
        this.errorMessage = "Failed to add artist to recording studio: Artist already exists in the studio.";
      }
    } else {
      this.showErrorDialog = true;
      this.errorMessage = "Failed to add artist to recording studio: Invalid artist or recording studio.";
    }
  }

  closeErrorDialog(): void {
    this.showErrorDialog = false;
    this.errorMessage = '';
  }

}
