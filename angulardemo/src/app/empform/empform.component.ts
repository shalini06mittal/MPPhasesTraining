import { Component } from '@angular/core';
import { Employee } from '../model/Employee';

@Component({
  selector: 'app-empform',
  standalone: false,
  
  templateUrl: './empform.component.html',
  styleUrl: './empform.component.css'
})
export class EmpformComponent {
    emp:Employee;
    constructor(){
      this.emp = {eid:1,ename:'',password:'',
        email:'',phone:''
        , address:{country:''}}
      }
      saveEmployee(){
        console.log(this.emp);
        
      }
}
