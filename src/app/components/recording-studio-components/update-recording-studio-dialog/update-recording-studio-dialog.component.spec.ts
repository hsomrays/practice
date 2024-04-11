import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateRecordingStudioDialogComponent } from './update-recording-studio-dialog.component';

describe('UpdateRecordingStudioDialogComponent', () => {
  let component: UpdateRecordingStudioDialogComponent;
  let fixture: ComponentFixture<UpdateRecordingStudioDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateRecordingStudioDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdateRecordingStudioDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
