import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpeditformComponent } from './empeditform.component';

describe('EmpeditformComponent', () => {
  let component: EmpeditformComponent;
  let fixture: ComponentFixture<EmpeditformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EmpeditformComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmpeditformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
