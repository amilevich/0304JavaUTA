import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AlertService, DoctorService } from '../_services';

@Component({
  selector: 'app-register-doctor',
  templateUrl: './register-doctor.component.html',
  styleUrls: ['./register-doctor.component.css']
})

export class RegisterDoctorComponent implements OnInit {
  registerDoctorForm: FormGroup;
  loading = false;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private doctorService: DoctorService,
    private alertService: AlertService) { }

  ngOnInit() {
    //this.registerDoctorForm = this.formBuilder.group({firstName: ['']});
    this.registerDoctorForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      userName: ['', Validators.required],
      medicalId: [''],
      ssN: [''],
      phone: [''],
      email: [''],
      street: [''],
      city: [''],
      state: [''],
      zipcode: [''],
      passWord: ['', [Validators.required, Validators.minLength(6)]]
    });

    /*     nav-PhysicianClass = {
                
            }*/
  }

  checkPasswords(group: FormGroup) { // here we have the 'passwords' group
    let pass = group.controls.passWord.value;
    let confirmPass = group.controls.confirmPassWord.value;
    
    return pass === confirmPass ? null : { notSame: true }     
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerDoctorForm.controls; }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.registerDoctorForm.invalid) {
      return;
    }

    this.loading = true;
    this.doctorService.register(this.registerDoctorForm.value)
      //.pipe(first())
      .subscribe(
        data => {
          this.alertService.success('Registration successful', true);
          this.router.navigate(['/login']);
        },
        error => {
          this.alertService.error(error);
          this.loading = false;
        });
  }
}
