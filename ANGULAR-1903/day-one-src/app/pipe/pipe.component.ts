import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipe',
  templateUrl: './pipe.component.html',
  styleUrls: ['./pipe.component.css']
})
export class PipeComponent implements OnInit {

  /* Pipe - is a way to display value transformations that you
  can declare in your HTML.
  A pipe takes integers, string, arrays, and dates as input
  to be converted in the format required and also display
  the same in the browser.
  {{ x | pipe }}

  standard ones - uppercase, lowercase, titlecase, currency

  custom pipe - @Pipe on a class, implement PipeTransform
  */

  str = 'Hello';
  num = 5;
  day = new Date();

  constructor() { }

  ngOnInit() {
  }

}
