import { TestBed } from '@angular/core/testing';

import { RecordingStudioService } from './recording-studio.service';

describe('RecordingStudioService', () => {
  let service: RecordingStudioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecordingStudioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
