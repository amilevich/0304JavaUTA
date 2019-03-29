import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { PokemonListComponent } from './pokemon-list/pokemon-list.component';
import { PokemonProfileComponent } from './pokemon-profile/pokemon-profile.component';
import { PokemonService } from './pokemon.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PokemonListComponent,
    PokemonProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path: 'home', component: HomeComponent},
      {path: 'pokemon', component: PokemonListComponent},
      {path: 'profile/:name', component: PokemonProfileComponent}
    ])
  ],
  providers: [ PokemonService],
  bootstrap: [AppComponent]
})
export class AppModule { }
