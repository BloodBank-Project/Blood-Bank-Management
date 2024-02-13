import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PatientRequest } from './patientRequest.model';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class DataSource {
  constructor(private http:HttpClient) {

  }

  getPatientRequest():Observable<PatientRequest[]>{
    alert("Datasource")
    return this.http.get<PatientRequest[]>(`http://localhost:8087/spring/patientRequest/allPatients`);
  }
  savePatientRequest(PatientRequest:PatientRequest):Observable<PatientRequest>{
    alert("Datasource"+PatientRequest)
    return this.http.post<PatientRequest>(`http://localhost:8087/spring/patientRequest`,PatientRequest);
  }
  deletePatient(requestId:number){
    return this.http.delete(`http://localhost:8087/spring/patientRequest/${requestId}`)
  }
}
