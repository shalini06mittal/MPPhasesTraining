import { Component } from '@angular/core';

@Component({
  selector: 'app-directives',
  standalone: false,
  
  templateUrl: './directives.component.html',
  styleUrl: './directives.component.css'
})
export class DirectivesComponent {
  // typescript -> it supports data types
  // structural directive
  persons =[
    {id:1, name:'shalini'},
    {id:2, name:'tom'},
  ]
  people: any[] = [
    {
    "name": "Douglas Pace",
    "age": 35,
    "country": 'MARS'
    },
    {
    "name": "Mcleod Mueller",
    "age": 32,
    "country": 'USA'
    },
    {
    "name": "Shalini Mittal",
    "age": 32,
    "country": 'INDIA'
    },
    {
    "name": "Aguirre Ellis",
    "age": 34,
    "country": 'UK'
    },
    {
    "name": "Cook Tyson",
    "age": 32,
    "country": 'USA'
    }
    ];
}
