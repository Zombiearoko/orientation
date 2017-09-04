import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginCostumerComponent } from './login-costumer.component';

describe('LoginCostumerComponent', () => {
  let component: LoginCostumerComponent;
  let fixture: ComponentFixture<LoginCostumerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginCostumerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginCostumerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
