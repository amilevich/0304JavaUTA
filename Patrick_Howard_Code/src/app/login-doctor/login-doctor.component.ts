import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { Doctor } from '../_models';

import { AlertService, AuthenticationService, DoctorService } from '../_services';

@Component({
  selector: 'app-login-doctor',
  templateUrl: './login-doctor.component.html',
  styleUrls: ['./login-doctor.component.css']
})
export class LoginDoctorComponent implements OnInit {
  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  private doctor : Doctor; 

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService,
    private doctorService: DoctorService,
    private alertService: AlertService) { }


  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      userName: ['', Validators.required],
      passWord: ['', Validators.required]
    });
    // reset login status
    this.authenticationService.logout();

    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';

  }
  get f() { return this.loginForm.controls; }

  onSubmit() {
    this.submitted = true;

    if (this.loginForm.invalid) {
      return;
    }

    this.loading = true;
    this.doctorService.login(this.loginForm.value)
    .subscribe((res: Doctor) => {
      this.doctor = res;
      this.router.navigate(['/profile-doctor', this.doctor.doctorId]);
    },
    error => {
      this.loading = false;
    });


    //     data  => {
    //     console.log("POST Request is successful ", data);
    //   },
    //     error  => {
    //     console.log("Error", error);
    //   }
    // );
    // .pipe(first())

  }
}
