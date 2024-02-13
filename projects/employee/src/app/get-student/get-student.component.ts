import { EmploreeRepo } from './../../Models/employee.repo';
import { Employee } from '../../Models/employee.model';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-get-student',
  templateUrl: './get-student.component.html',
  styleUrls: ['./get-student.component.css'],
})
export class GetStudentComponent{
  public employees:Employee[]=[];

  constructor(private repo: EmploreeRepo) {
  }

  get employee(){
   this.employees=this.repo.getEmployeeDetails();
   console.log(this.employees);
   return this.employees;

  }
  deleteStudent(id:any){
    console.log(id);
  this.repo.deleteEmployee(id);
  }


}
