import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Artist} from "../models/artist";
import { environment } from '../../environments/environment';
import {EnvironmentService} from "./environment.service";

@Injectable({
  providedIn: 'root'
})
export class ArtistService {
  apiUrl?: string;
  constructor(private httpClient: HttpClient,
              private environmentService: EnvironmentService) {
    this.apiUrl = this.environmentService.getValue('apiUrl') + '/artists';
  }

  getArtistsList(): Observable<Artist[]>{
    return this.httpClient.get<Artist[]>(`${this.apiUrl}`);
  }


  createArtist(artist: Artist): Observable<Artist>{
    return this.httpClient.post<Artist>(`${this.apiUrl}`, artist);
  }

  getArtistById(id: number): Observable<Artist>{
    return this.httpClient.get<Artist>(`${this.apiUrl}/${id}`);
  }

  updateArtist(artistId: number, artist: Artist | undefined): Observable<Object>{
    console.log(artist);
    return this.httpClient.put(`${this.apiUrl}/${artistId}`, artist)
  }

  deleteArtist(artistId: number | undefined): Observable<Object>{
    return this.httpClient.delete(`${this.apiUrl}/${artistId}`);
  }

}
