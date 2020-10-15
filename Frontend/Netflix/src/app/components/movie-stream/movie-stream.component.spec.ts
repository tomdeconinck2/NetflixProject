import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieStreamComponent } from './movie-stream.component';

describe('MovieStreamComponent', () => {
  let component: MovieStreamComponent;
  let fixture: ComponentFixture<MovieStreamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MovieStreamComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieStreamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
