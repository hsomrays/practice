import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Artist} from "../models/artist";

@Injectable({
  providedIn: 'root'
})
export class ArtistService {

  private baseURL = "http://localhost:8080/api/artists";
  constructor(private httpClient: HttpClient) { }

  getArtistsList(): Observable<Artist[]>{
    return this.httpClient.get<Artist[]>(`${this.baseURL}`);
  }


  createArtist(artist: Artist, recordingStudioId: number): Observable<Artist>{
    const body = artist;
    const params = { recordingStudioId: recordingStudioId };
    return this.httpClient.post<Artist>(this.baseURL, body, { params: params });
    //return this.httpClient.post(`${this.baseURL}`, artist)
  }

  getArtistById(id: number): Observable<Artist>{
    return this.httpClient.get<Artist>(`${this.baseURL}/${id}`);
  }

  updateArtist(artist: Artist): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${artist.id}`, artist)
  }

  deleteArtist(id: number | undefined): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
