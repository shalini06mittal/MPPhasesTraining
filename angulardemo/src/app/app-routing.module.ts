import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeesComponent } from './employees/employees.component';
import { EmpformComponent } from './empform/empform.component';
import { LoginComponent } from './login/login.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { ProfileComponent } from './profile/profile.component';
import { ProfiledetailComponent } from './profiledetail/profiledetail.component';
import { authGuard } from './service/auth.guard';
import { EmpeditformComponent } from './empeditform/empeditform.component';

const routes: Routes = [
  {path:'' ,redirectTo:'employees',pathMatch:'full'},
  {path:'employees', component:EmployeesComponent},
  {path:'add', component:EmpformComponent, canActivate: [authGuard]},
  {path:'login', component:LoginComponent},
  {path:'edit', component:EmpeditformComponent},
  {path:'employees/:id', component:ProfileComponent,canActivate:[authGuard] ,  
    children:[
    {path:'detail', component:ProfiledetailComponent}
 ]
},
  {path:'**' ,component:PagenotfoundComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
