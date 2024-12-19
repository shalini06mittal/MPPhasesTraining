import { Component, DoCheck, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit, OnChanges, DoCheck, OnDestroy{
  // js
  x: Promise<string> | null = Promise.resolve("hello world");
  title = 'Welcome To Angular Learning!!';
  // h1 => text of he
  message = 'Something';
  isEnabled:boolean = true;
  username = 'shalini'

  newemp:any;
  
  showForm:boolean = false;

  toggleForm(){
    this.showForm = !this.showForm;
  }
  newEmpAdded(newemp:any){
      console.log(newemp)
      this.newemp = newemp;
      this.showForm = !this.showForm;
    }

  constructor(){
    console.log('app component constructor');
  }
  ngOnDestroy(): void {
    console.log('app component destroy');
  }
  ngDoCheck(): void {
    console.log('app component do check');
  }
  ngOnChanges(changes: SimpleChanges): void {
    console.log('app component on changes');
  }
  ngOnInit(): void {
    console.log('app component on init');
  }
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
