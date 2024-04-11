import {Component, OnDestroy, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {RecordingStudio} from "../../../models/recording-studio";
import {RecordingStudioService} from "../../../services/recording-studio.service";
import {animate, state, style, transition, trigger} from "@angular/animations";

@Component({
  selector: 'app-create-recording-studio-dialog',
  templateUrl: './create-recording-studio-dialog.component.html',
  styleUrl: './create-recording-studio-dialog.component.css',
  animations: [
    trigger('modalAppear', [
      state('void', style({ opacity: 0})), // начальное состояние до появления
      state('*', style({ opacity: 1})), // состояние после появления
      transition('void => *', animate('300ms ease-in')), // анимация появления
      transition('* => void', animate('300ms ease-out')) // анимация исчезновения
    ])
  ]
})
export class CreateRecordingStudioDialogComponent implements OnInit, OnDestroy {

  recordingStudio: RecordingStudio = new RecordingStudio();

  constructor(
    public dialogRef: MatDialogRef<CreateRecordingStudioDialogComponent>,
    private recordingStudioService: RecordingStudioService,
  ) {  }

  ngOnInit() {
  }

  ngOnDestroy() {
  }

  saveRecordingStudio() {
    this.recordingStudioService.createRecordingStudio(this.recordingStudio).subscribe(
      data => {
        console.log(data);
        this.dialogRef.close();
      },
      error => console.log(error as any)
    );
  }

  cancel() {
    this.dialogRef.close();
  }
}

