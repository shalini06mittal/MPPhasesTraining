import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/Employee';
import { ActivatedRoute, Router } from '@angular/router';
import { EmphttpService } from '../service/emphttp.service';

@Component({
  selector: 'app-empeditform',
  standalone: false,
  
  templateUrl: './empeditform.component.html',
  styleUrl: './empeditform.component.css'
})
export class EmpeditformComponent implements OnInit{
  
  emp:Employee ;

  constructor(private router:Router, private empservice:EmphttpService){
    this.emp = history.state;
  }
  ngOnInit(): void {
    
  
  }
  editEmployee(){
    
    this.empservice.updateEmployee(this.emp).subscribe(resp=> {
      console.log(resp);
      this.router.navigate([''])
  });
    
  }
  
}
