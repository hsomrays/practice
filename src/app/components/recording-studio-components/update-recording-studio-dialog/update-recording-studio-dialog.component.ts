import {Component, OnInit, OnDestroy, Inject} from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { RecordingStudio } from "../../../models/recording-studio";
import { RecordingStudioService } from "../../../services/recording-studio.service";
import {animate, state, style, transition, trigger} from "@angular/animations";

@Component({
  selector: 'app-update-recording-studio-dialog',
  templateUrl: './update-recording-studio-dialog.component.html',
  styleUrls: ['./update-recording-studio-dialog.component.css'],
  animations: [
    trigger('modalAppear', [
      state('void', style({ opacity: 0})), // начальное состояние до появления
      state('*', style({ opacity: 1})), // состояние после появления
      transition('void => *', animate('300ms ease-in')), // анимация появления
      transition('* => void', animate('300ms ease-out')) // анимация исчезновения
    ])
  ]
})
export class UpdateRecordingStudioDialogComponent implements OnInit, OnDestroy {

  constructor(
    @Inject(MAT_DIALOG_DATA) public recordingStudio: RecordingStudio,
    public dialogRef: MatDialogRef<UpdateRecordingStudioDialogComponent>,
    private recordingStudioService: RecordingStudioService,
  ) {  }

  ngOnInit() {
  }

  ngOnDestroy() {
  }

  updateRecordingStudio() {
    if (this.recordingStudio.id !== undefined) {
      this.recordingStudioService.updateRecordingStudio(this.recordingStudio).subscribe(updatedRecordingStudio => {
        console.log(updatedRecordingStudio);
        this.dialogRef.close(updatedRecordingStudio);
      });
    }
  }

  cancel() {
    this.dialogRef.close();
  }
}
