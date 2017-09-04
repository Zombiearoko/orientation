import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BourseComponent } from './bourse.component';

describe('BourseComponent', () => {
  let component: BourseComponent;
  let fixture: ComponentFixture<BourseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BourseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
