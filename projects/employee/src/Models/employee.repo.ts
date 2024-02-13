import { Employee } from './employee.model';
import { Injectable, OnInit } from '@angular/core';
import { DataSource } from './employee.datasource';

@Injectable({providedIn: 'root'})
export class EmploreeRepo{

  public employee:Employee[]=[];

  constructor(private dataSource:DataSource) {
      this.getEmployees();
   }

  getEmployees(){
     this.dataSource.getEmployees().subscribe(data=>{
      this.employee=data;
    })
  }

  getEmployeeDetails():Employee[]{
    return this.employee;
  }

  sendEmployee(emp:Employee){
    this.dataSource.saveEmployee(emp).subscribe(
      (data)=>{
       console.log(data);
     },
    (error)=>{
     console.error("error no data found");
    }
    )
  }

  deleteEmployee(id: number) {
    console.log('Deleting employee with ID:', id);
    this.dataSource.deleteEmployee(id).subscribe(() => {
      console.log('Employee deleted successfully.');
    });
  }

}
