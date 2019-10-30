import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonaEditComponent } from './persona-edit.component';

describe('PersonaEditComponent', () => {
  let component: PersonaEditComponent;
  let fixture: ComponentFixture<PersonaEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonaEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonaEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
