import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RecordingStudio} from "../models/recording-studio";
import {Artist} from "../models/artist";

@Injectable({
  providedIn: 'root'
})
export class RecordingStudioService {

  private baseURL = "http://localhost:8080/api/recordingStudios";
  constructor(private httpClient: HttpClient) { }

  getRecordingStudiosList(): Observable<RecordingStudio[]>{
    return this.httpClient.get<RecordingStudio[]>(`${this.baseURL}`);
  }

  getArtistsList(id: number | undefined): Observable<Artist[]>{
    return this.httpClient.get<Artist[]>(`${this.baseURL}/${id}/artists`);
  }

  createRecordingStudio(recordingStudio: RecordingStudio): Observable<RecordingStudio>{
    return this.httpClient.post(`${this.baseURL}`, recordingStudio)
  }

  getRecordingStudioById(id: number): Observable<RecordingStudio>{
    return this.httpClient.get<RecordingStudio>(`${this.baseURL}/${id}`);
  }

  updateRecordingStudio(id: number, recordingStudio: RecordingStudio): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, recordingStudio)
  }

  deleteRecordingStudio(id: number | undefined): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
