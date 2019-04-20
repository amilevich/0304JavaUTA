import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '../../environments/environment';
import { Doctor } from '../_models';

@Injectable()
export class DoctorService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<Doctor[]>(`${environment.apiUrl}/getdoctors`);
    }

    getById(id: number) {
        return this.http.get(`${environment.apiUrl}/getdoctor/?doctorId=` + id);
    }

    register(doctor: Doctor) {
        return this.http.post(`${environment.apiUrl}/insertDoctor`, doctor);
    }  

    login(doctor: Doctor) {
        return this.http.post(`${environment.apiUrl}/logindoc`, doctor);
    }

    update(doctor: Doctor) {
        return this.http.post(`${environment.apiUrl}/updateDoctor`, doctor);
    }     

    getSpecialties() {
        return this.http.get(`${environment.apiUrl}/getspecialties`);
    }

    getConditions() {
        return this.http.get(`${environment.apiUrl}/getconditions`);
    }

    getProcedures() {
        return this.http.get(`${environment.apiUrl}/getprocedures`);
    }

    getSelectedDoctors(parameters: String) {
        //return this.http.get(`${environment.apiUrl}/getdoctorsbylocation?origin=2420 E. Lamar Blvd, Arlington TX 76006&procedureId=0&specialtyId=0&conditionId=0`);
        let baseURL = `${environment.apiUrl}/getdoctorsbylocation`;
        return this.http.get(baseURL + parameters);
    }
    // update(user: User) {
    //     return this.http.put(`${environment.apiUrl}/users/` + user.id, user);
    // }

    // delete(id: number) {
    //     return this.http.delete(`${environment.apiUrl}/users/` + id);
    // }
}