import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonasListComponent } from './personas-list.component';

describe('PersonasListComponent', () => {
  let component: PersonasListComponent;
  let fixture: ComponentFixture<PersonasListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonasListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonasListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
