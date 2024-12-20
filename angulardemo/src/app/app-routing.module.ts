import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeesComponent } from './employees/employees.component';
import { EmpformComponent } from './empform/empform.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path:'employees', component:EmployeesComponent},
  {path:'add', component:EmpformComponent},
  {path:'login', component:LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
