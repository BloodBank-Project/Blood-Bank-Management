
import { Component, OnInit } from '@angular/core';
import { Employee } from '../../Models/employee.model';
import { DataSource } from '../../Models/employee.datasource';
import { EmploreeRepo } from '../../Models/employee.repo';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent{
  emp:Employee=new Employee(0,'',0,0);
  constructor(private repo:EmploreeRepo) { }

  SendEmployee(emp:Employee){
    console.log("*********"+emp);
    alert(JSON.stringify(emp));
   this.repo.sendEmployee(emp);
  }
}
