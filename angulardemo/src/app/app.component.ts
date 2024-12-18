import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent {
  // js
  title = 'Welcome To Angular Learning!!';
  // h1 => text of he
  message = 'Something';
  isEnabled:boolean = true;
  username = 'shalini'
  clicked(){
    alert('hey')

  }

  /**
   * list of products -> details of every product
   * * list of employees -> details of every employee
   * * list of blogs -> details of every blog
   * * list of hotels -> details of every hotel
   * employeescomponent -> gets the list of employees
   * we iterate over the list of employees get each employee
   * from the list and pass that object to employeecomplonent
   * 
   * 
   */
}
