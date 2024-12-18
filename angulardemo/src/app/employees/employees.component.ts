import { Component } from '@angular/core';
import { employees } from '../model/data';

@Component({
  selector: 'app-employees',
  standalone: false,
  
  templateUrl: './employees.component.html',
  styleUrl: './employees.component.css'
})
export class EmployeesComponent {

  employees = employees; // REST API -> database
}
