import {Component, Inject, OnDestroy, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {RecordingStudio} from "../../../models/recording-studio";
import {RecordingStudioService} from "../../../services/recording-studio.service";
import {Artist} from "../../../models/artist";
import {ArtistService} from "../../../services/artist.service";
import {animate, state, style, transition, trigger} from "@angular/animations";

@Component({
  selector: 'app-update-artist-dialog',
  templateUrl: './update-artist-dialog.component.html',
  styleUrl: './update-artist-dialog.component.css',
  animations: [
    trigger('modalAppear', [
      state('void', style({ opacity: 0})), // начальное состояние до появления
      state('*', style({ opacity: 1})), // состояние после появления
      transition('void => *', animate('300ms ease-in')), // анимация появления
      transition('* => void', animate('300ms ease-out')) // анимация исчезновения
    ])
  ]
})
export class UpdateArtistDialogComponent implements OnInit, OnDestroy {

  constructor(
    @Inject(MAT_DIALOG_DATA) public artist: Artist,
    public dialogRef: MatDialogRef<UpdateArtistDialogComponent>,
    private artistService: ArtistService,
  ) {  }

  ngOnInit() {
  }

  ngOnDestroy() {
  }

  updateArtist() {
    if (this.artist.id !== undefined) {
      this.artistService.updateArtist(this.artist.id, this.artist).subscribe(updatedArtist => {
        console.log(updatedArtist);
        this.dialogRef.close(updatedArtist);
      });
    }
  }

  cancel() {
    this.dialogRef.close();
  }
}

