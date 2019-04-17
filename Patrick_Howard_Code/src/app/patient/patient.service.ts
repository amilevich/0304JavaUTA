import { Injectable } from '@angular/core';
import { Patient } from "./patient";
import { Http, Response } from "@angular/http";
import { Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable()
export class PatientService {
private apiUrl = '/api/login.app';
constructor(private http: Http) {
 }
findAll(): Promise<Array<Patient>> {
 return this.http.get(this.apiUrl)
 .toPromise()
 .then(response => response.json() as Patient[])
 .catch(this.handleError);
 }
createPatient(patient: Patient): Promise<Array<Patient>> {
 let patHeaders = new Headers({ 'Content-Type': 'application/json' });
 return this.http.post(this.apiUrl, JSON.stringify(patient), { headers: patHeaders })
 .toPromise()
 .then(response => response.json() as Patient[])
 .catch(this.handleError);
 }
deletePatientById(id: number): Promise<Array<Patient>> {
 const url = `${this.apiUrl}/${id}`;
 return this.http.delete(url)
 .toPromise()
 .then(response => response.json() as Patient[])
 .catch(this.handleError);
 }
private handleError(error: any): Promise<Array<any>> {
 console.error('An error occurred', error);
 return Promise.reject(error.message || error);
 }
}