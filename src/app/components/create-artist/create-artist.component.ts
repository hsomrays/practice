import {Component, Inject, OnDestroy, OnInit} from '@angular/core';
import {Artist} from "../../models/artist";
import {ArtistService} from "../../services/artist.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";


@Component({
  selector: 'app-create-artist',
  templateUrl: './create-artist.component.html',
  styleUrl: './create-artist.component.css'
})

export class CreateArtistComponent implements OnInit, OnDestroy {

  artist: Artist = new Artist();


  constructor(
    @Inject(MAT_DIALOG_DATA) public recordingStudioId: number,
    public dialogRef: MatDialogRef<CreateArtistComponent>,
    private artistService: ArtistService
  ) {
  }


  ngOnInit() {
  }

  ngOnDestroy() {
  }


  createArtist() {
    if (this.recordingStudioId !== undefined) {
      this.artistService.createArtist(this.artist, this.recordingStudioId).subscribe(artist => {
        console.log(artist);
        this.dialogRef.close(artist);
      });
    }
  }

  cancel() {
    this.dialogRef.close();
  }

}
