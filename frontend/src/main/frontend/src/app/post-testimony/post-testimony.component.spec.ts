import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PostTestimonyComponent } from './post-testimony.component';

describe('PostTestimonyComponent', () => {
  let component: PostTestimonyComponent;
  let fixture: ComponentFixture<PostTestimonyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PostTestimonyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PostTestimonyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
