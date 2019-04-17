import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule }    from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { UiSwitchModule } from 'ngx-ui-switch';

// used to create fake backend
import { fakeBackendProvider } from './_helpers';
import { AppComponent }  from './app.component';
import { routing }        from './app.routing';
import { AlertComponent } from './_directives';
import { AuthGuard } from './_guards';
import { JwtInterceptor, ErrorInterceptor } from './_helpers';
import { AlertService, AuthenticationService, UserService, DoctorService, PatientService } from './_services';
import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';
import { SearchComponent } from './search/search.component'
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { RegisterDoctorComponent } from './register-doctor/register-doctor.component';
import { LoginDoctorComponent } from './login-doctor/login-doctor.component';
import { ProfileDoctorComponent } from './profile-doctor/profile-doctor.component';
import { SearchAreaComponent } from './search-area/search-area.component'
import { AgmCoreModule, GoogleMapsAPIWrapper } from '@agm/core';

@NgModule({
    imports: [
        BrowserModule,
        UiSwitchModule,
        ReactiveFormsModule,
        HttpClientModule,
        routing,
        AgmCoreModule.forRoot({apiKey: 'AIzaSyAfkqpU8t3OHmpyKv3TFCe0UuzjEsXjC9I'}),
    ],
    declarations: [
        AppComponent,
        AlertComponent,
        HomeComponent,
        LoginComponent,
        RegisterComponent,
        HeaderComponent,
        FooterComponent,
        SearchComponent,
        RegisterDoctorComponent,
        LoginDoctorComponent ,
        ProfileDoctorComponent ,
        SearchAreaComponent  ],
    providers: [
        AuthGuard,
        AlertService,
        AuthenticationService,
        DoctorService,
        PatientService,
        UserService,
        GoogleMapsAPIWrapper ,
        { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
        { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },

        // provider used to create fake backend
        fakeBackendProvider
    ],
    bootstrap: [AppComponent]
})

export class AppModule { }