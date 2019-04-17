import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AlertService, DoctorService } from '../_services';
import { Doctor } from '../_models';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-profile-doctor',
  templateUrl: 'profile-doctor.component.html',
  styleUrls: ['profile-doctor.component.css']
})
export class ProfileDoctorComponent implements OnInit {
  profileDoctorForm: FormGroup;
  loading = false;
  submitted = false;
  myresponse: any;
  private doctor: Doctor;
  private myId: number;

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private doctorService: DoctorService,
    private alertService: AlertService,
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.profileDoctorForm = this.formBuilder.group({
      firstName: [''],
      lastName: [''],
      userName: [''],
      ssN: [''],
      gender: [''],
      phone: [''],
      email: [''],
      street: [''],
      city: [''],
      state: [''],
      zipcode: [''],
      street2: [''],
      city2: [''],
      state2: [''],
      zipcode2: [''],
      education: [''],
      experience: [''],
      affiliation: [''],
      certification: ['']
    });

    this.route.params.subscribe((params: Params) => this.myId = params['id']);
    this.doctorService.getById(this.myId)
      .subscribe((res: Doctor) => {
        this.doctor = res;
      });
    this.profileDoctorForm.disable();

  }


  onEditChange(evnt) {
    if (evnt)
      this.profileDoctorForm.enable();
    else
      this.profileDoctorForm.disable();
  }

  // convenience getter for easy access to form fields
  get f() { return this.profileDoctorForm.controls; }

  onSubmit() {
    this.submitted = true;

    if (this.f.gender.dirty)
      this.doctor.gender = this.f.gender.value;

    if (this.f.education.dirty)
      this.doctor.education = this.f.education.value;

    if (this.f.experience.dirty)
      this.doctor.experience = this.f.experience.value;

    if (this.f.street.dirty)
      this.doctor.street = this.f.street.value;

    if (this.f.city.dirty)
      this.doctor.city = this.f.city.value;

    if (this.f.state.dirty)
      this.doctor.state = this.f.state.value;

    if (this.f.zipcode.dirty)
      this.doctor.zipcode = this.f.zipcode.value;

    if (this.f.affiliation.dirty)
      this.doctor.affiliation = this.f.affiliation.value;

    if (this.f.certification.dirty)
      this.doctor.certification = this.f.certification.value;

    if (this.f.street2.dirty)
      this.doctor.street2 = this.f.street2.value;

    if (this.f.city2.dirty)
      this.doctor.city2 = this.f.city2.value;

    if (this.f.state2.dirty)
      this.doctor.state2 = this.f.state2.value;

    if (this.f.zipcode2.dirty)
      this.doctor.zipcode2 = this.f.zipcode2.value;


    this.doctorService.update(this.doctor)
      .subscribe((res: Doctor) => {
        window.location.reload(true);
      },
        error => {
          this.loading = false;
        });

  }
}
