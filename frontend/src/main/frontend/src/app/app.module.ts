import { routes } from './app.rooter';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { RestProvider } from '../providers/rest/rest';
import { HomePageComponent } from '../pages/home/home';
import { HelloComponent } from './hello/hello.component';
import { CreateArticleComponent } from './create-article/create-article.component';
import { AdministratorLoginComponent } from './administrator-login/administrator-login.component';
import { HomeComponent } from './home/home.component';
import { ServiceComponent } from './service/service.component';
import { ContactsComponent } from './contacts/contacts.component';
import { AboutComponent } from './about/about.component';
import { CreateAccountCustomerComponent } from './create-account-customer/create-account-customer.component';
import { SessionClientComponent } from './session-client/session-client.component';

@NgModule({
  declarations: [
    AppComponent,
     HomePageComponent,
     HelloComponent,
     CreateArticleComponent,
     AdministratorLoginComponent,
     HomeComponent,
     ServiceComponent,
     ContactsComponent,
     AboutComponent,
     CreateAccountCustomerComponent,
     SessionClientComponent
  ],
  imports: [
   BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    routes,
  ],
  providers: [
  RestProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
