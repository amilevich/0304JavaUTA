import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OneAndAHalfComponent } from './one-and-a-half.component';

describe('OneAndAHalfComponent', () => {
  let component: OneAndAHalfComponent;
  let fixture: ComponentFixture<OneAndAHalfComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OneAndAHalfComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OneAndAHalfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
