import { PostTestimonyComponent } from './post-testimony/post-testimony.component';
import { LoginCostumerComponent } from './login-costumer/login-costumer.component';
import { AdministratorLoginComponent } from './administrator-login/administrator-login.component';
import { LibrairieComponent } from './librairie/librairie.component';
import { BasketComponent } from './basket/basket.component';
import { AppComponent } from './app.component';
import { SessionAdminComponent } from './session-admin/session-admin.component';
import { SessionClientComponent } from './create-account-customer/session-client/session-client.component';
import { CreateAccountCustomerComponent } from './create-account-customer/create-account-customer.component';
import { AboutComponent } from './about/about.component';
import { ContactsComponent } from './contacts/contacts.component';
import { ServiceComponent } from './service/service.component';
import { HomeComponent } from './home/home.component';
import { ModuleWithProviders, Component } from '@angular/core';
import { Routes, RouterModule, Router} from '@angular/router';
import { OffreComponent } from './offre/offre.component';


export const router: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'services', component: ServiceComponent },
  { path: 'contacts', component: ContactsComponent },
  { path: 'about', component: AboutComponent },
  { path: 'subcribe', component: AboutComponent },
   { path: 'account', component: CreateAccountCustomerComponent },
    { path: 'sessionCostumer', component: SessionClientComponent },
    { path: 'basket', component: BasketComponent },
{ path: 'bookshop', component: LibrairieComponent},
{ path: 'sessionAdmin', component: SessionAdminComponent},
{ path: 'loginAdmin', component: AdministratorLoginComponent},
{ path: 'loginCostumer', component: LoginCostumerComponent},
{ path: 'postTestimony', component: PostTestimonyComponent},
{ path: 'offre', component: OffreComponent},


];


export const routes: ModuleWithProviders = RouterModule.forRoot(router);
