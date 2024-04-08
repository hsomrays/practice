import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowArtistsDialogComponent } from './show-artists-dialog.component';

describe('ShowArtistsDialogComponent', () => {
  let component: ShowArtistsDialogComponent;
  let fixture: ComponentFixture<ShowArtistsDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ShowArtistsDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShowArtistsDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
