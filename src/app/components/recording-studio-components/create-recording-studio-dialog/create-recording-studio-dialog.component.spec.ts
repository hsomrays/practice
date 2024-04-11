import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateRecordingStudioDialogComponent } from './create-recording-studio-dialog.component';

describe('CreateRecordingStudioDialogComponent', () => {
  let component: CreateRecordingStudioDialogComponent;
  let fixture: ComponentFixture<CreateRecordingStudioDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateRecordingStudioDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateRecordingStudioDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
