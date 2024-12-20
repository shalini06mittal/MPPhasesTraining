import { Component } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-observables',
  standalone: false,
  
  templateUrl: './observables.component.html',
  styleUrl: './observables.component.css'
})
export class ObservablesComponent {

  data:Observable<string> | null = null;

  fruits:Array<string> = [];
  anyErrors:boolean = false;
  finished:boolean = false;

  subscriber:any;

  start(){
    this.data = new Observable(observer =>{
      console.log("Observable starts producing data");
      
      setTimeout(()=> observer.next("Apple"), 1000);
      setTimeout(()=> observer.next("Mangoes"), 2000);
      setTimeout(()=> observer.next("Strawberries"), 3000);
      setTimeout(()=> observer.next("Banana"), 4000);

      setTimeout(()=> observer.next("Blueberries"), 1000);
      setTimeout(()=> observer.next("oranges"), 5000);
      setTimeout(()=> observer. complete(), 7000);
    });
    console.log(this.data);
    this.data.subscribe({
        next: (fruit) => this.fruits.push(fruit),
        error : (errmsg)=> this.anyErrors = true,
        complete: () => this.finished = true
    })
    
  }

}
