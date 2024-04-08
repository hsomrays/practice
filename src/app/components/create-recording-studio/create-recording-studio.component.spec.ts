import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateRecordingStudioComponent } from './create-recording-studio.component';

describe('CreateRecordingStudioComponent', () => {
  let component: CreateRecordingStudioComponent;
  let fixture: ComponentFixture<CreateRecordingStudioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateRecordingStudioComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateRecordingStudioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
