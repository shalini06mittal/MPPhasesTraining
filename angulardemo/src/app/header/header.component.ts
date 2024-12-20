import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-header',
  standalone: false,
  
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent{
  constructor(public us:UserService, private router: Router){}

  logout(){
    
    this.us.logout();
    this.router.navigate(['']);
  }


}
