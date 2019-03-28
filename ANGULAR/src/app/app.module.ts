import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FirstComponent } from './first/first.component';
import { SecondComponent } from './second/second.component';
import { NavComponent } from './nav/nav.component';
import { PokemonComponent } from './pokemon/pokemon.component';
import { ClickerComponent } from './clicker/clicker.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';



const appRoutes: Routes = [

  {
    path: 'first',
    component: FirstComponent
  },
  {
    path: 'second',
    component: SecondComponent
  },
  {
    path: 'pokemon',
    component: PokemonComponent
  },
  {
    path: 'clicker',
    component: ClickerComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    SecondComponent,
    NavComponent,
    PokemonComponent,
    ClickerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    CommonModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
