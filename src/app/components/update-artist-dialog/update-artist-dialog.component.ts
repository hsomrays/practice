import {Component, Inject, OnDestroy, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {RecordingStudio} from "../../models/recording-studio";
import {RecordingStudioService} from "../../services/recording-studio.service";
import {Artist} from "../../models/artist";
import {ArtistService} from "../../services/artist.service";

@Component({
  selector: 'app-update-artist-dialog',
  templateUrl: './update-artist-dialog.component.html',
  styleUrl: './update-artist-dialog.component.css'
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

  updateRecordingStudio() {
    if (this.artist.id !== undefined) {
      this.artistService.updateArtist(this.artist).subscribe(updatedArtist => {
        console.log(updatedArtist);
        this.dialogRef.close(updatedArtist);
      });
    }
  }

  cancel() {
    this.dialogRef.close();
  }
}

