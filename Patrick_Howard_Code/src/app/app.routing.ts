import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';
import { LoginDoctorComponent } from './login-doctor';
import { RegisterDoctorComponent } from './register-doctor';
import { SearchComponent } from './search';
import { SearchAreaComponent } from './search-area';
import { AuthGuard } from './_guards';
import { ProfileDoctorComponent } from './profile-doctor/profile-doctor.component';

const appRoutes: Routes = [
    { path: '', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'search', component: SearchComponent },
    { path: 'search-area', component: SearchAreaComponent },
    { path: 'login-doctor', component: LoginDoctorComponent },
    { path: 'register-doctor', component: RegisterDoctorComponent },
    { path: 'profile-doctor/:id', component: ProfileDoctorComponent },

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);