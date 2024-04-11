import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {ArtistService} from "../../../services/artist.service";
import {RecordingStudioService} from "../../../services/recording-studio.service";
import {RecordingStudio} from "../../../models/recording-studio";
import {Artist} from "../../../models/artist";
import {animate, state, style, transition, trigger} from "@angular/animations";

@Component({
  selector: 'app-show-artists-dialog',
  templateUrl: './show-artists-dialog.component.html',
  styleUrl: './show-artists-dialog.component.css',
  animations: [
    trigger('modalAppear', [
      state('void', style({ opacity: 0})), // начальное состояние до появления
      state('*', style({ opacity: 1})), // состояние после появления
      transition('void => *', animate('300ms ease-in')), // анимация появления
      transition('* => void', animate('300ms ease-out')) // анимация исчезновения
    ])
  ]
})
export class ShowArtistsDialogComponent {

  artists: Artist[] = [];

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    private recordingStudioService: RecordingStudioService,
    private artistService: ArtistService,
    public dialogRef: MatDialogRef<ShowArtistsDialogComponent>,
  ) {
  }

  ngOnInit() {
  }

  ngOnDestroy() {
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

  deleteArtistFromRecordingStudio(artist: Artist, recordingStudio: RecordingStudio): void {
    if (artist && recordingStudio) {
      const artistIndex = recordingStudio.artists?.indexOf(artist);
      if (artistIndex !== undefined && artistIndex !== -1) {
        recordingStudio.artists?.splice(artistIndex, 1); // Удаление артиста из массива artists
        console.log(recordingStudio);
        this.recordingStudioService.updateRecordingStudio(recordingStudio).subscribe(data => {
          console.log(data);
          this.getArtists();
        }, error => {
          console.error("Failed to update recording studio:", error);
        });
      } else {
        console.error("Failed to delete artist from recording studio: Artist not found.");
      }
    } else {
      console.error("Failed to delete artist from recording studio: Invalid artist or recording studio.");
    }
  }


}
