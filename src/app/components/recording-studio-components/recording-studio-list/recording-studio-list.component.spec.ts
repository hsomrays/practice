import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecordingStudioListComponent } from './recording-studio-list.component';

describe('RecordingStudioListComponent', () => {
  let component: RecordingStudioListComponent;
  let fixture: ComponentFixture<RecordingStudioListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RecordingStudioListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RecordingStudioListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
