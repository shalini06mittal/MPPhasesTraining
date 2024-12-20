import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-login',
  standalone: false,
  
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  public loginValid = true;
  public username = 'abc';
  public password = 'abc123';

  constructor(private router:Router, private userserv:UserService) { }

  /**
   * when user click on login button, get token for valid credentials and redirect to home page
   * or display an error message for invalid credentials and remain on login page
   */
  public onSubmit(): void {
    this.loginValid = true;
    console.log('login',this.username, this.password)
    this.userserv.loginUser(this.username)
    .subscribe({
      next: resp => {
            console.log(resp);
            if(resp !== undefined  && resp.length!=0)
              {
                for(let user of resp){
                  if(user.password === this.password){
                    localStorage.setItem("username",this.username);
                    this.router.navigate(['']);
                  }
                }
                
              }
              else{
                this.loginValid = false;
              }
      },
      error: err => this.loginValid = false
    });
  }


}
