import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAccountCustomerComponent } from './create-account-customer.component';

describe('CreateAccountCustomerComponent', () => {
  let component: CreateAccountCustomerComponent;
  let fixture: ComponentFixture<CreateAccountCustomerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateAccountCustomerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateAccountCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
