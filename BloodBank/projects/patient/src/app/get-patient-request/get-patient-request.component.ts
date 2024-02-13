import { Component } from '@angular/core';
import { PatientRequest } from '../../Models/patientRequest.model';
import { PatientRequestRepo } from '../../Models/patientRequest.repo';

@Component({
  selector: 'app-get-patient-request',
  templateUrl: './get-patient-request.component.html',
  styleUrl: './get-patient-request.component.css'
})
export class GetPatientRequestComponent {
public request:PatientRequest[]=[];

  constructor(private repository:PatientRequestRepo){}

  getPatient(){
    alert("Component")
    this.request=this.repository.getPatientRequestDetails();
    console.log(this.request);
   return this.request;
  }
  delete(id:any){
    console.log(id);
    this.repository.deletePatientRequest(id)

  }
}
