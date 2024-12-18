import { Component } from '@angular/core';

@Component({
  selector: 'app-country',
  standalone: false,
  
  templateUrl: './country.component.html',
  styleUrl: './country.component.css'
})
export class CountryComponent {
  countries = ['India','UK','USA'];
  selectedCountry:string = 'UK'
}
