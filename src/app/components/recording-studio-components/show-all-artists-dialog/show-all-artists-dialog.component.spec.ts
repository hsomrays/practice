import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowAllArtistsDialogComponent } from './show-all-artists-dialog.component';

describe('ShowAllArtistsDialogComponent', () => {
  let component: ShowAllArtistsDialogComponent;
  let fixture: ComponentFixture<ShowAllArtistsDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ShowAllArtistsDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShowAllArtistsDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
