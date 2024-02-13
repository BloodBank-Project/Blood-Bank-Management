import { Component } from '@angular/core';
import { PatientRequest } from '../../Models/patientRequest.model';
import { PatientRequestRepo } from '../../Models/patientRequest.repo';

@Component({
  selector: 'app-patinet-requesting',
  templateUrl: './patinet-requesting.component.html',
  styleUrl: './patinet-requesting.component.css'
})
export class PatinetRequestingComponent {
  public request:PatientRequest=new PatientRequest(0,0,new Date(),'','');

  constructor(private repo:PatientRequestRepo){}

  SendRequest(patinet:PatientRequest){
    console.log("----------"+patinet);
    alert(JSON.stringify(patinet));
    this.request=patinet;
    alert(this.request)
    this.repo.sendPatientRequest(this.request);
    alert("component-inserted"+patinet)
  }
}
