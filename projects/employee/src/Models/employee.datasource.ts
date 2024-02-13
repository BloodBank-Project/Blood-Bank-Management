import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee.model';

@Injectable({providedIn: 'root'})
export class DataSource {
  constructor(private http:HttpClient) { }

  getEmployees():Observable<Employee[]>{
   return this.http.get<Employee[]>(`http://localhost:8088/stud/fetch`);

  }
  saveEmployee(Employee:Employee):Observable<Employee>{
      return this.http.post<Employee>(`http://localhost:8088/stud/saveemp`,Employee);
  }

  deleteEmployee(employeeId:number){
    console.log(employeeId);
    return this.http.delete(`http://localhost:8088/stud/delete/${employeeId}`);

  }
}
