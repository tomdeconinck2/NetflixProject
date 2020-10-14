import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecificUserComponent } from './specific-user.component';

describe('SpecificUserComponent', () => {
  let component: SpecificUserComponent;
  let fixture: ComponentFixture<SpecificUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpecificUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpecificUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
