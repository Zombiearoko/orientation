import { CreateAccountCustomerComponent } from './create-account-customer/create-account-customer.component';
import { AboutComponent } from './about/about.component';
import { ContactsComponent } from './contacts/contacts.component';
import { ServiceComponent } from './service/service.component';
import { HomeComponent } from './home/home.component';
import { ModuleWithProviders, Component } from '@angular/core';
import { Routes, RouterModule} from '@angular/router';




export const router: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent },
  {path: 'services', component: ServiceComponent},
  {path: 'contacts', component: ContactsComponent},
  {path: 'about', component: AboutComponent},
  {path: 'subcribe', component: AboutComponent},
  {path: 'bookshoop', component: AboutComponent},
   {path: 'account', component: CreateAccountCustomerComponent},

];

export const routes: ModuleWithProviders = RouterModule.forRoot(router);
