import { Component, Input, OnInit, SimpleChanges } from '@angular/core';
import { employees } from '../model/data';
import { Employee } from '../model/Employee';
import { EmphttpService } from '../service/emphttp.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employees',
  standalone: false,

  templateUrl: './employees.component.html',
  styleUrl: './employees.component.css',
})
export class EmployeesComponent implements OnInit {
  employees = employees; // REST API -> database
  @Input()
  newemp: any = {};

  constructor(public empservice:EmphttpService, private router:Router, private route:ActivatedRoute){

  }
  ngOnInit(): void {
      this.empservice.getAllEmployees()
      .subscribe(resp => this.employees = resp)
  }
  ngOnChanges(changes: SimpleChanges): void {
    console.log(this.newemp);
    if (this.newemp !== undefined) this.employees.unshift(this.newemp);
  }
  delete(emp: Employee) {
    // let objindx = this.employees.findIndex(
    //   (employee) => employee.eid === emp.eid
    // );
    // this.employees.splice(objindx, 1);
    this.empservice.deleteEmployee(""+emp.eid).subscribe(resp => console.log(resp));
    
  }
  edit(emp: Employee) {
    // complete the code to display a form to edit and update the employee
    console.log(emp);
  }
  viewProfile(id:number)
  	{
      //http://localhost:4200/employees/1
      this.router.navigate([id], {relativeTo:this.route})
  	}

}
