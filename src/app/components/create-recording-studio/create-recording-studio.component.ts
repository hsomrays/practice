import { Component } from '@angular/core';
import {RecordingStudio} from "../../models/recording-studio";
import {RecordingStudioService} from "../../services/recording-studio.service";
import { Router } from '@angular/router';
import {error} from "@angular/compiler-cli/src/transformers/util";

@Component({
  selector: 'app-create-recording-studio',
  templateUrl: './create-recording-studio.component.html',
  styleUrl: './create-recording-studio.component.css'
})
export class CreateRecordingStudioComponent {

  recordingStudio: RecordingStudio = new RecordingStudio();

  constructor(private recordingStudioService: RecordingStudioService, private router: Router) {  }

  ngOnInit(): void{
  }

  saveRecordingStudio() {
    this.recordingStudioService.createRecordingStudio(this.recordingStudio).subscribe(
      data => {
        console.log(data);
        this.goToRecordingStudioList();
      },
      error => console.log(error as any)
    );
  }

  goToRecordingStudioList(){
    this.router.navigate(['/recordingStudios']);
  }

  onSubmit(){
    console.log(this.recordingStudio);
    this.saveRecordingStudio();
  }

}
