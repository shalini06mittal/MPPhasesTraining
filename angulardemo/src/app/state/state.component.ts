import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-state',
  standalone: false,
  
  templateUrl: './state.component.html',
  styleUrl: './state.component.css'
})
export class StateComponent {

  states:any = {
    UK:['Bristol','London'],
    USA:['Chicago','New York'],
    India:['Delhi','Pune'],
  }
  @Input()
  country = 'UK';
  selectedStates = this.states[this.country];

}
