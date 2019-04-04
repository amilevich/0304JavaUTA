import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { RandomJokeComponent } from './random-joke/random-joke.component';
import { SearchJokeComponent } from './search-joke/search-joke.component';
import { SecretComponent } from './secret/secret.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { JokeService } from './joke.service';


@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    RandomJokeComponent,
    SearchJokeComponent,
    SecretComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot([
      {path: 'welcome', component: WelcomeComponent},
      {path: 'joke', component: RandomJokeComponent},
      {path: 'search', component: SearchJokeComponent},
      {path: 'secret', component: SecretComponent}
    ]),
    HttpClientModule,
    FormsModule
  ],
  providers: [JokeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
