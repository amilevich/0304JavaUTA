import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { RandomJokeComponent } from './random-joke/random-joke.component';
import { JokeService } from './shared/joke.service';
import { SearchJokeComponent } from './search-joke/search-joke.component';
import {FormsModule} from '@angular/forms';
import { DodgeComponent } from './dodge/dodge.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    RandomJokeComponent,
    SearchJokeComponent,
    DodgeComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot([
      {path: 'welcome', component: WelcomeComponent},
      {path: 'joke', component: RandomJokeComponent},
      {path: 'search', component: SearchJokeComponent},
      {path: 'dodge', component: DodgeComponent},
      // {path: 'metahumans-form', component: MetahumanFormComponent},
      // {path: 'profile/:name', component: ProfileComponent},
      {path: '', redirectTo: 'welcome', pathMatch: 'full' },
      {path: '**', redirectTo: 'welcome', pathMatch: 'full' },
    ]), HttpClientModule, FormsModule
  ],
  providers: [JokeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
