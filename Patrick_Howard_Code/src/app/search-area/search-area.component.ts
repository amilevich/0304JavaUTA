import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AlertService, DoctorService } from '../_services';
import { } from '@agm/core/services/google-maps-types';
import { AgmCoreModule, MapsAPILoader } from "@agm/core";


declare var google: any;

@Component({
  selector: 'app-search-area',
  templateUrl: 'search-area.component.html',
  styleUrls: ['search-area.component.css']
})
export class SearchAreaComponent implements OnInit {
  geocoder:any;
  searchForm: FormGroup;

  private doctors = [];

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private doctorService: DoctorService,
    private mapsAPILoader: MapsAPILoader,
    private agmCoreModule: AgmCoreModule,
    private alertService: AlertService) { }

  ngOnInit() {
    this.mapsAPILoader.load().then(() => {
      this.geocoder = new google.maps.Geocoder();
      
  //  const mexicoCity = new google.maps.LatLng(19.432608, -99.133209);
  //   const jacksonville = new google.maps.LatLng(40.730610, -73.935242);
  //   const distance = google.maps.geometry.spherical.computeDistanceBetween(mexicoCity, jacksonville);
      // const bounds = new google.maps.LatLngBounds(
      //   new google.maps.LatLng(54.69726685890506, -2.7379201682812226),
      //   new google.maps.LatLng(55.38942944437183, -1.2456105979687226)
      // );
      this.findLocation("1303 Beechwood Dr, Friendswood, TX 77546");
    }
    );
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

    this.doctorService.getSelectedDoctors()
      .subscribe((res: any[]) => {
        this.doctors = res;
      });


  }

  findLocation(address) {
    if (!this.geocoder) this.geocoder = new google.maps.Geocoder()
    this.geocoder.geocode({
      'address': address
    }, (results, status) => {
      console.log(results);
      if (status == google.maps.GeocoderStatus.OK) {
                // decompose the result
      } else {
        alert("Sorry, this search produced no results.");
      }
    })
  }

  onSubmit() {
  }

}
