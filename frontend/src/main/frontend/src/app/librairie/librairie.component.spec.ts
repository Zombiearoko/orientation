import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrairieComponent } from './librairie.component';

describe('LibrairieComponent', () => {
  let component: LibrairieComponent;
  let fixture: ComponentFixture<LibrairieComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LibrairieComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LibrairieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
