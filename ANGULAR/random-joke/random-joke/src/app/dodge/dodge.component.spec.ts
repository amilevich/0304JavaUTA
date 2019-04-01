import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DodgeComponent } from './dodge.component';

describe('DodgeComponent', () => {
  let component: DodgeComponent;
  let fixture: ComponentFixture<DodgeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DodgeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DodgeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
