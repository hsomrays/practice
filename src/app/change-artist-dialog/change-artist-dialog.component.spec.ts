import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangeArtistDialogComponent } from './change-artist-dialog.component';

describe('ChangeArtistDialogComponent', () => {
  let component: ChangeArtistDialogComponent;
  let fixture: ComponentFixture<ChangeArtistDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ChangeArtistDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ChangeArtistDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
