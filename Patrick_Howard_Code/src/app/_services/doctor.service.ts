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