import {Component, Inject, OnDestroy, OnInit} from '@angular/core';
import {Artist} from "../../../models/artist";
import {ArtistService} from "../../../services/artist.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import { trigger, state, style, transition, animate } from '@angular/animations';


@Component({
  selector: 'app-create-artist',
  templateUrl: './create-artist.component.html',
  styleUrl: './create-artist.component.css',
  animations: [
    trigger('modalAppear', [
      state('void', style({ opacity: 0})), // начальное состояние до появления
      state('*', style({ opacity: 1})), // состояние после появления
      transition('void => *', animate('300ms ease-in')), // анимация появления
      transition('* => void', animate('300ms ease-out')) // анимация исчезновения
    ])
  ]
})

export class CreateArtistComponent implements OnInit, OnDestroy {

  artist: Artist = new Artist();

  constructor(
    public dialogRef: MatDialogRef<CreateArtistComponent>,
    private artistService: ArtistService
  ) {
  }

  ngOnInit() {
  }

  ngOnDestroy() {
  }


  createArtist() {
      this.artistService.createArtist(this.artist).subscribe(artist => {
        console.log(artist);
        this.dialogRef.close(artist);
      });
  }

  cancel() {
    this.dialogRef.close();
  }

}
