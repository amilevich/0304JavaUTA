import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PokemonListComponent } from './pokemon-list/pokemon-list.component';
import { PokemonService } from './pokemon.service';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { PokemonComponent } from './pokemon/pokemon.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    PokemonListComponent,
    PokemonComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path: 'pokemon', component: PokemonListComponent},
      {path: '1-pokemon', component: PokemonComponent},
      {path: 'home', component: HomeComponent}
    ])
  ],
  providers: [PokemonService],
  bootstrap: [AppComponent]
})
export class AppModule { }
