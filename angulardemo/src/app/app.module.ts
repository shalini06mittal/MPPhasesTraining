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
import { LifecycleComponent } from './lifecycle/lifecycle.component';
import { ChildComponent } from './lifecycle/child.component';
import { ServiceComponent } from './service/service.component';
import { ObservablesComponent } from './observables/observables.component';
import { HttpClientModule, provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { ProfiledetailComponent } from './profiledetail/profiledetail.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { EmpeditformComponent } from './empeditform/empeditform.component';
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
    EmpformComponent,
    LifecycleComponent,
    ChildComponent,
    ServiceComponent,
    ObservablesComponent,
    LoginComponent,
    ProfileComponent,
    PagenotfoundComponent,
    ProfiledetailComponent,
    EmpeditformComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,MatButtonModule, MatCardModule,MatInputModule
  ],
  providers: [provideHttpClient(withInterceptorsFromDi()), provideAnimationsAsync()],
  bootstrap: [AppComponent]
})
export class AppModule { }
