import { Component } from '@angular/core';
import { Employee } from '../model/Employee';
import { ActivatedRoute, Router } from '@angular/router';
import { EmphttpService } from '../service/emphttp.service';

@Component({
  selector: 'app-profile',
  standalone: false,
  
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {

  employee:Employee;
  constructor(private route:ActivatedRoute, private es :EmphttpService,
      private router:Router) {
      this.employee = {eid:0,ename:'',phone:'',email:'',password:"",address:{country:''}}
   }
// localhost:4200/employees/1
    ngOnInit(): void {
      this.route.params.subscribe(data => {
        console.log(data['id'])
        this.employee.eid = data['id']
         this.es.getEmployeeById(data['id'])
         .subscribe(emp => this.employee = emp);
      })
    }

    displayAddress()
  {
    this.router.navigate(['detail'],{relativeTo:this.route})
  }


}
