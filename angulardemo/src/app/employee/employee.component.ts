import { Component, Input } from '@angular/core';
import { Employee } from '../model/Employee';

@Component({
  selector: 'app-employee',
  standalone: false,
  
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent {

  @Input()
  employee:Employee
constructor() { 
    this.employee = {eid:1,ename:'',password:'',
    email:'',phone:''
    , address:{country:''}}
  }

}
