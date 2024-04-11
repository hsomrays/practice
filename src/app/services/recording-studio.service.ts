import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RecordingStudio} from "../models/recording-studio";
import {EnvironmentService} from "./environment.service";

@Injectable({
  providedIn: 'root'
})


export class RecordingStudioService {
  apiUrl?: string;
  constructor(private httpClient: HttpClient,
              private environmentService: EnvironmentService) {
    this.apiUrl = this.environmentService.getValue('apiUrl') + '/recordingStudios';
  }

  getRecordingStudiosList(): Observable<RecordingStudio[]>{
    return this.httpClient.get<RecordingStudio[]>(`${this.apiUrl}`);
  }

  createRecordingStudio(recordingStudio: RecordingStudio): Observable<Object>{
    return this.httpClient.post(`${this.apiUrl}`, recordingStudio)
  }

  getRecordingStudioById(id: number): Observable<RecordingStudio>{
    return this.httpClient.get<RecordingStudio>(`${this.apiUrl}/${id}`);
  }

  updateRecordingStudio(recordingStudio: RecordingStudio): Observable<Object>{
    return this.httpClient.put(`${this.apiUrl}/${recordingStudio.id}`, recordingStudio)
  }

  deleteRecordingStudio(id: number | undefined): Observable<Object>{
    return this.httpClient.delete(`${this.apiUrl}/${id}`);
  }
}
