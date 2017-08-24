import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministratorLoginComponent } from './administrator-login.component';

describe('AdministratorLoginComponent', () => {
  let component: AdministratorLoginComponent;
  let fixture: ComponentFixture<AdministratorLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdministratorLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministratorLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
