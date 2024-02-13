import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { GetStudentComponent } from './get-student/get-student.component';

const routes: Routes = [
  {
   path:"AddEmployee",component:AddEmployeeComponent
  },
  {
    path:"GetEmployee",component:GetStudentComponent
  },
  {
    path:"",redirectTo:"GetEmployee",pathMatch:"full"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
