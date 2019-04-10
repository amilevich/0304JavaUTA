import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Angular-SpringMVC';

  myresponse: any;

  APP_URL = 'http://localhost:9005/Springmvcangular';

  constructor(private _http: HttpClient) {}

  getAllEmployees() {
    this._http.get(this.APP_URL + '/getemployees').subscribe(
      data => {
        this.myresponse = data;
      },
      error => {
        console.log('Error occured', error);
      }
    )
  }
}
