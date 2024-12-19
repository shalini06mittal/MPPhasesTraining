import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { EmployeeComponent } from './employee/employee.component';
import { DirectivesComponent } from './directives/directives.component';
import { CountryComponent } from './country/country.component';
import { StateComponent } from './state/state.component';
import { EmployeesComponent } from './employees/employees.component';
import { TodosComponent } from './todos/todos.component';
import { EmpformComponent } from './empform/empform.component';
// @ - decorator
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    EmployeeComponent,
    DirectivesComponent,
    CountryComponent,
    StateComponent,
    EmployeesComponent,
    TodosComponent,
    EmpformComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
