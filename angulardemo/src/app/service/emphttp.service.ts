import { Injectable } from '@angular/core';
import { Employee } from '../model/Employee';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmphttpService {

  url:string = "http://localhost:3000/employees";
  constructor(private http:HttpClient) { }

  getAllEmployees():Observable<any>
  {
    return this.http.get<any>(this.url);
  }
  getEmployeeById(eid:number):Observable<Employee>
  {
    return this.http.get<Employee>(this.url+'/'+eid);
  }
  addEmployee(employee:Employee):Observable<Employee>
  {
    employee['id'] = employee.eid;
    return this.http.post<Employee>(this.url, employee);
  }
  updateEmployee(employee:Employee):Observable<Employee>
  {
    return this.http.put<Employee>(this.url+'/'+employee.eid, employee);
  }
  deleteEmployee(eid:string){
    return this.http.delete(this.url+'/'+eid)
  }

}
