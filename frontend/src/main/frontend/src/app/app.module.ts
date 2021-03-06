import { NavigationComponent } from './navigation/navigation.component';
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
import { ContactsComponent } from './contacts/contacts.component';
import { AboutComponent } from './about/about.component';
import { CreateAccountCustomerComponent } from './create-account-customer/create-account-customer.component';
import { SessionClientComponent } from './create-account-customer/session-client/session-client.component';
import { SessionAdminComponent } from './session-admin/session-admin.component';
import { BasketComponent } from './basket/basket.component';
import { LibrairieComponent } from './librairie/librairie.component';
import { StageComponent } from './stage/stage.component';
import { ProgrammeComponent } from './programme/programme.component';
import { BourseComponent } from './bourse/bourse.component';
import { LoginCostumerComponent } from './login-costumer/login-costumer.component';
import { PostTestimonyComponent } from './post-testimony/post-testimony.component';
import { PopupModule } from 'ng2-opd-popup';
//import {MaterialModule} from '@angular/material';
import { BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { ServiceComponent } from './service/service.component';
import { OffreComponent } from './offre/offre.component';
import { SplashScreenComponent } from './splash-screen/splash-screen.component';
import { SessionComponent } from './session/session.component';
import { GuardComponent } from './guard';

@NgModule({
  declarations: [
    AppComponent,
     HomePageComponent,
     HelloComponent,
     CreateArticleComponent,
     AdministratorLoginComponent,
     HomeComponent,
     ContactsComponent,
     AboutComponent,
     ServiceComponent,
     CreateAccountCustomerComponent,
     SessionClientComponent,
     SessionAdminComponent,
     BasketComponent,
     LibrairieComponent,
     StageComponent,
     ProgrammeComponent,
     BourseComponent,
     LoginCostumerComponent,
     PostTestimonyComponent,
     NavigationComponent,
     OffreComponent,
     SplashScreenComponent,
     SessionComponent,
     GuardComponent
  ],
  imports: [
   BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    routes,
    PopupModule.forRoot(),
   // MaterialModule,
    BrowserAnimationsModule
  ],
  providers: [
  RestProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
