import {Component, OnDestroy, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {ArtistService} from "../../../services/artist.service";
import {Artist} from "../../../models/artist";
import {clearAllBodyScrollLocks, disableBodyScroll, enableBodyScroll} from "body-scroll-lock";
import {UpdateArtistDialogComponent} from "../update-artist-dialog/update-artist-dialog.component";
import {CreateArtistComponent} from "../create-artist/create-artist.component";

@Component({
  selector: 'app-artist-list',
  templateUrl: './artist-list.component.html',
  styleUrl: './artist-list.component.css'
})
export class ArtistListComponent implements OnInit, OnDestroy {

  artists: Artist[] = [];

  constructor(
    private artistService: ArtistService,
    private dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.getArtists();
  }

  ngOnDestroy() {
    clearAllBodyScrollLocks();
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

  openAddArtistDialog() {

    const targetElement = document.querySelector('body')!;
    disableBodyScroll(targetElement);

    const dialogRef = this.dialog.open(CreateArtistComponent, {
      width: '500px',
      disableClose: true // Запретить закрытие модального окна по клику вне его
    });

    dialogRef.afterClosed().subscribe(() => {
      this.getArtists();
      enableBodyScroll(targetElement); // Разблокировать прокрутку
    });
  }

  deleteArtist(artistId: number | undefined) {
    this.artistService.deleteArtist(artistId).subscribe(data => {
      console.log(data);
      this.getArtists();
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
