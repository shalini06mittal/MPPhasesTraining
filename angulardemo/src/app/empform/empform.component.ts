import { Component, EventEmitter, Output } from '@angular/core';
import { Employee } from '../model/Employee';
import { EmphttpService } from '../service/emphttp.service';

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

    constructor(public empservice:EmphttpService){
      this.emp = {eid:1,ename:'',password:'',
        email:'',phone:''
        , address:{country:''}}
      }
      saveEmployee(){
        console.log(this.emp); 
        this.empservice.addEmployee(this.emp).subscribe(resp => console.log(resp));
        
        // this.empadded.emit(this.emp)
        // this.emp={eid:0, ename:'',email:'',phone:'',password:'', address:{city:"", country:"", zipcode:0}}
      }
}
