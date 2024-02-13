import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PatinetRequestingComponent } from './patinet-requesting/patinet-requesting.component';
import { GetPatientRequestComponent } from './get-patient-request/get-patient-request.component';

const routes: Routes = [
  {
    path:"patientRequesting",component:PatinetRequestingComponent
  },
  {
    path:"getPatientRequest",component:GetPatientRequestComponent
  }
];
// patientRequesting
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
