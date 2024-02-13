export class PatientRequest{
    constructor(
        public patient_request_id:number,
        public patient_request_units:number,
        public patient_request_on_date:Date,
        public patient_medical_condition:string,
        public status:string
    ){}
}