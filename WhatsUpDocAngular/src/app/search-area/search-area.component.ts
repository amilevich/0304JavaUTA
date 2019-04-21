import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AlertService, DoctorService } from '../_services';
import { } from '@agm/core/services/google-maps-types';
import { AgmCoreModule, MapsAPILoader } from "@agm/core";
import { Doctor } from '../_models';
import { element } from '@angular/core/src/render3/instructions';

declare var google: any;

@Component({
  selector: 'app-search-area',
  templateUrl: 'search-area.component.html',
  styleUrls: ['search-area.component.css']
})
export class SearchAreaComponent implements OnInit {
  geocoder:any;
  searchForm: FormGroup;
  selectedSpecialty: string;
  hideRow: boolean;

  private doctors = [];

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private doctorService: DoctorService,
    private mapsAPILoader: MapsAPILoader,
    private agmCoreModule: AgmCoreModule,
    private alertService: AlertService) { }


  ngOnInit() {
    this.selectedSpecialty = "";
    // this.mapsAPILoader.load().then(() => {
    //   this.geocoder = new google.maps.Geocoder();
      
  //  const mexicoCity = new google.maps.LatLng(19.432608, -99.133209);
  //   const jacksonville = new google.maps.LatLng(40.730610, -73.935242);
  //   const distance = google.maps.geometry.spherical.computeDistanceBetween(mexicoCity, jacksonville);
      // const bounds = new google.maps.LatLngBounds(
      //   new google.maps.LatLng(54.69726685890506, -2.7379201682812226),
      //   new google.maps.LatLng(55.38942944437183, -1.2456105979687226)
      // );
   // }
   // );
    this.searchForm = this.formBuilder.group({
      physiciansName: [''],
      searchField: [''],
      specialty: [''],
      insuranceProvider: ['']
    });



    // const googleMapsClient = require('@google/maps').createClient({
    //   key: 'AIzaSyAfkqpU8t3OHmpyKv3TFCe0UuzjEsXjC9I'
    // });

    //  const mexicoCity = new google.maps.LatLng(19.432608, -99.133209);
    // const jacksonville = new google.maps.LatLng(40.730610, -73.935242);
    // const distance = google.maps.geometry.spherical.computeDistanceBetween(mexicoCity, jacksonville);
    let patientId = localStorage.getItem('patientId');
    let patientAddr = localStorage.getItem('patientAddr');
    //alert(patientAddr);
    let parameters = "?origin=" + patientAddr + "&procedureId=0&specialtyId=0&conditionId=0";
    console.log(parameters);
    this.doctorService.getSelectedDoctors(parameters)
      .subscribe((res: any[]) => {
        this.doctors = res;
      });


  }

  cardClick(doctorId: number) {
    this.router.navigate(['/profile-doctor', doctorId]);
  }


  onSubmit(event: any) {
    // let patientAddr = localStorage.getItem('patientAddr');
    // //alert(patientAddr);
    // let parameters = "?origin=" + patientAddr + "&procedureId=0&specialtyId=0&conditionId=0";
    // this.doctorService.getSelectedDoctors(parameters)
    // .subscribe((res: any[]) => {
    //   this.doctors = res;
    // });
    //alert("click - " + event.target.specialty.value);

    // // working somewhat
    this.selectedSpecialty = event.target.specialty.value;
    // this.doctors =  this.doctors.filter(function(dr) {
    //   return selectedSpecialty == dr.specialty;
    // })
    
    // let cloneDoctors = Object.assign({}, this.doctors);
    // cloneDoctors.forEach(( item, index) => {
    //   if (item.specialty != selectedSpecialty) this.doctors.splice(index,1);
    // });
    //this.doctors = this.doctors.filter(obj => obj. !== selectedSpecialty)
  }

  isFiltered(doc: Doctor) {
    this.hideRow = true;
     if (this.selectedSpecialty == "") {
      this.hideRow = false;
      return doc;
     }
     else if (this.selectedSpecialty == doc.specialty) {
       this.hideRow = false;
       return doc; // this.selectedSpecialty == doc.specialty;
     }
  }

}
