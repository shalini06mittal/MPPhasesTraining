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
}
