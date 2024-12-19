import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lifecycle',
  standalone: false,
  
  templateUrl: './lifecycle.component.html',
  styleUrl: './lifecycle.component.css'
})
export class LifecycleComponent implements OnInit {
  pcountry:string ='usa';
  emp = {"name":"Shalini"}
  show =false;
  constructor() {
  console.log(`parent constructor`);
  }
  ngOnInit(): void {
  console.log(`parent ng oninit `);
  }
}
