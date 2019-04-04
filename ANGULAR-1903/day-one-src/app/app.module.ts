import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FirstComponent } from './first/first.component';
import { OneAndAHalfComponent } from './one-and-a-half/one-and-a-half.component';
import { NavComponent } from './nav/nav.component';
import { Routes, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ClickerComponent } from './clicker/clicker.component';
import { PipeComponent } from './pipe/pipe.component';
import { HeroComponent } from './hero/hero.component';
import { HeroesComponent } from './heroes/heroes.component';

const appRoutes: Routes = [
  {
    path: 'first',
    component: FirstComponent
  },
  {
    path: 'oneandahalf',
    component: OneAndAHalfComponent
  },
  {
    path: 'clicker',
    component: ClickerComponent
  },
  { 
    path: 'pipe',
    component: PipeComponent
  },
  {
    path: 'heroes',
    component: HeroesComponent
  }
];


@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    OneAndAHalfComponent,
    NavComponent,
    ClickerComponent,
    PipeComponent,
    HeroComponent,
    HeroesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    CommonModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
