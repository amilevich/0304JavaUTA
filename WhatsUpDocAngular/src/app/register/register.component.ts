import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AlertService, PatientService } from '../_services';

@Component({
    selector: 'app-register',
    templateUrl: 'register.component.html',
    styleUrls: ['register.component.css']
})

export class RegisterComponent implements OnInit {
    registerForm: FormGroup;
    loading = false;
    submitted = false;

    constructor(
        private formBuilder: FormBuilder,
        private router: Router,
        private patientService: PatientService,

        private alertService: AlertService) { }

    ngOnInit() {
        this.registerForm = this.formBuilder.group({
            firstName: ['', Validators.required],
            lastName: ['', Validators.required],
            userName: ['', Validators.required],
            ssN: [''],
            gender: [''],
            phone: [''],
            email: [''],
            street: [''],
            city: [''],
            state: [''],
            zipcode: [''],
            passWord: ['', [Validators.required, Validators.minLength(6)]],
            confirmPassWord: ['']
        }, {validator: this.checkPasswords });

    }
    
checkPasswords(group: FormGroup) { // here we have the 'passwords' group
    let pass = group.controls.passWord.value;
    let confirmPass = group.controls.confirmPassWord.value;
    
    return pass === confirmPass ? null : { notSame: true }     
  }

    // convenience getter for easy access to form fields
    get f() { return this.registerForm.controls; }
  
    onSubmit() {
      this.submitted = true;
  
      // stop here if form is invalid
      if (this.registerForm.invalid) {
        return;
      }
  
      this.loading = true;
      this.patientService.register(this.registerForm.value)
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
