import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AlertService, DoctorService } from '../_services';
import { Specialties, Conditions, Procedures } from '../_models';

@Component({
  selector: 'app-search',
  templateUrl: 'search.component.html',
  styleUrls: ['search.component.css']
})
export class SearchComponent implements OnInit {
  searchForm: FormGroup;
  private specialties: Specialties[];
  private conditions: Conditions[];
  private procedures: Procedures[];

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private doctorService: DoctorService,
    private alertService: AlertService) { }

  ngOnInit() {
    this.searchForm = this.formBuilder.group({
      physiciansName: [''],
      searchField: [''],
      specialty: [''],
      insuranceProvider: ['']
    });

    this.doctorService.getSpecialties()
      .subscribe((res: Specialties[]) => {
        this.specialties = res;
        this.doctorService.getConditions()
          .subscribe((res: Conditions[]) => {
            this.conditions = res;
            this.doctorService.getProcedures()
              .subscribe((res: Procedures[]) => {
                this.procedures = res;
              });
          });
      });




  }
  onSubmit() {
    this.router.navigate(['/search-area']);
  }
}
