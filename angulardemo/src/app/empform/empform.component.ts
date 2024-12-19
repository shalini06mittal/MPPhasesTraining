import { Component, EventEmitter, Output } from '@angular/core';
import { Employee } from '../model/Employee';

@Component({
  selector: 'app-empform',
  standalone: false,
  
  templateUrl: './empform.component.html',
  styleUrl: './empform.component.css'
})
export class EmpformComponent {
    emp:Employee;
    @Output()
    empadded:EventEmitter<Employee> = new EventEmitter();

    constructor(){
      this.emp = {eid:1,ename:'',password:'',
        email:'',phone:''
        , address:{country:''}}
      }
      saveEmployee(){
        console.log(this.emp); 
        this.empadded.emit(this.emp)
        this.emp={eid:0, ename:'',email:'',phone:'',password:'', address:{city:"", country:"", zipcode:0}}
      }
}
