import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SessionClientComponent } from './session-client.component';

describe('SessionClientComponent', () => {
  let component: SessionClientComponent;
  let fixture: ComponentFixture<SessionClientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SessionClientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SessionClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
