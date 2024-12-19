import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpformComponent } from './empform.component';

describe('EmpformComponent', () => {
  let component: EmpformComponent;
  let fixture: ComponentFixture<EmpformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EmpformComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmpformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
