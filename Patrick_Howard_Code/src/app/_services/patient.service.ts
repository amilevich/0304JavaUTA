import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '../../environments/environment';
import { Patient } from '../_models';

@Injectable()
export class PatientService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<Patient[]>(`${environment.apiUrl}/getpatients`);
    }

    register(patient: Patient) {
        return this.http.post(`${environment.apiUrl}/insertPatient`, patient);
    }       

    login(patient: Patient) {
        return this.http.post(`${environment.apiUrl}/loginpat`, patient);
    }

    getSpecialties() {
        return this.http.get(`http://localhost:3000/specialties`);
    }

    getConditions() {
        return this.http.get(`http://localhost:3000/conditions`);
    }

    getProcedures() {
        return this.http.get(`http://localhost:3000/procedures`);
    }

    getSelectedDoctors() {
        return this.http.get(`http://localhost:3000/doctors`);
    }
    // update(user: User) {
    //     return this.http.put(`${environment.apiUrl}/users/` + user.id, user);
    // }

    // delete(id: number) {
    //     return this.http.delete(`${environment.apiUrl}/users/` + id);
    // }
}