import { Injectable } from '@angular/core';
import { Response, HttpModule, RequestOptions, RequestMethod, RequestOptionsArgs, Http, Headers } from '@angular/http';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

/*
  Generated class for the RestProvider provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular 2 DI.
*/
@Injectable()
export class RestProvider {
  public beginUrl = 'http://localhost:8092';
  public loggedIn = false; 
  public isLogIn: boolean;
    constructor(public http: Http) {
    this.loggedIn = !!localStorage.getItem('auth_token');

    }

public getHello(name, surname) {
      const headers1 =  new Headers({ 'Access-Control-Allow-Origin': '*' });
      const options = new RequestOptions({  headers: headers1 });
    const url = 'http://127.0.0.1:8080/hello' + '?name=' + name + '&surname=' + surname;
    const url2 = '/api/hello' + '?name=' + name + '&surname=' + surname;
    const url3 = 'https://jsonplaceholder.typicode.com/post';
    // alert("toto 2");
      return  this.http.post(url, options)
              .do((res: Response ) => console.log(res.json()))
              .map((res: Response ) => res.json());
}

public postArticle(title, articleContent) {
    const headers1 =  new Headers({ 'Access-Control-Allow-Origin': '*' });
const options = new RequestOptions({  headers: headers1 });
      const object = [
      { title: title, articleContent: articleContent }
    ];
    const url = this.beginUrl + '?title=' + title + '&articleContent=' + articleContent;
    const url1 = 'http://127.0.0.1:8080/orientation/administrator/createArticle' +
     '?title=' + title + '&articleContent=' + articleContent;
      const url2 = 'https://jsonplaceholder.typicode.com/posts';
    return  this.http.post(url, object, options)
              .do((res: Response ) => console.log(res.json()))
              .map((res: Response ) => res.json());
}
          public   getArticle() {

    }
          public postAccount(firstNameCustomer, lastNameCustomer, emailAddress, password, phoneNumber) {
      const headers1 =  new Headers({ 'Access-Control-Allow-Origin': '*' });
const options = new RequestOptions({  headers: headers1 });
      const object = {
        nom: firstNameCustomer,
        prenom: lastNameCustomer,
        email: emailAddress,
        motDePasse: password,
        telephone: phoneNumber
       };
       const url = this.beginUrl+'/orientation/surfer/inscription'+'?firstNameCustomer='+firstNameCustomer+'&lastNameCustomer='+lastNameCustomer+'&phoneNumber='+phoneNumber+'&emailAddress='+emailAddress
    + '&password='+password ;
   
    return  this.http.post(url, object, options)
              .do((res: Response ) => console.log(res.json()))
              .map((res: Response ) => res.json());
}

     public getName(firstNameCustomer) {
      const headers1 =  new Headers({ 'Access-Control-Allow-Origin': '*' });
const options = new RequestOptions({  headers: headers1 });
      const object = {
        nom: firstNameCustomer
       };
       const url = this.beginUrl+'/orientation/surfer/inscription'+'?firstNameCustomer='+firstNameCustomer;
     
    return  this.http.post(url, object, options)
              .do((res: Response ) => console.log(res.json()))
              .map((res: Response ) => res.json());
}




          public postBookInBasket(bookName) {
      const headers1 =  new Headers({ 'Access-Control-Allow-Origin': '*' });
const options = new RequestOptions({  headers: headers1 });
      const object = {
        bookName: bookName,
       };
      const url = this.beginUrl + '?title=' + '?firstNameCustomer='+ bookName;
    const url1 = 'http://127.0.0.1:8080/customer/addCustomer' + '?firstNameCustomer='
    + bookName;
      const url2 = 'https://jsonplaceholder.typicode.com/posts';
    return  this.http.post(url, object, options)
              .do((res: Response ) => console.log(res.json()))
              .map((res: Response ) => res.json());
}

public removeFromBasket(bookName) {
      const headers1 =  new Headers({ 'Access-Control-Allow-Origin': '*' });
const options = new RequestOptions({  headers: headers1 });
      const object = {
        bookName: bookName,
       };

    const url = 'http://127.0.0.1:8080/customer/addCustomer' + '?firstNameCustomer='
    + bookName;
      const url2 = 'https://jsonplaceholder.typicode.com/posts';
    return  this.http.post(url, object, options)
              .do((res: Response ) => console.log(res.json()))
              .map((res: Response ) => res.json());
}

 public postLoginCostumer(login, password) {
   this.isLogIn = false;
    const headers1 =  new Headers({ 'Access-Control-Allow-Origin': '*' });
const options = new RequestOptions({  headers: headers1 });
      const object = {
        login: login,
        motDePasse: password,
       };
const url = this.beginUrl+'/orientation/customer/authentication'+'?login='+login+'&password='+password ;      
      const url2 = 'https://jsonplaceholder.typicode.com/posts';
    return  this.http.post(url, object, options)
              .do((res: Response ) => console.log(res.json()))
              .map((res: Response ) => res.json());
              
}

public postTestimony(testimonyAuthor, testimonyContent) {
      const headers1 =  new Headers({ 'Access-Control-Allow-Origin': '*' });
const options = new RequestOptions({  headers: headers1 });
      const object = {
        testimonyAuthor: testimonyAuthor,
        testimonyContent: testimonyContent,
       };
      const url = this.beginUrl  + '?testimonyAuthor=' + testimonyAuthor+ '&testimonyContent =' + testimonyContent ;
    const url1 = 'http://127.0.0.1:8080/customer/postTestimony' + '?testimonyAuthor=' + testimonyAuthor
    + '&testimonyContent =' + testimonyContent ;
      const url2 = 'https://jsonplaceholder.typicode.com/posts';
    return  this.http.post(url, object, options)
              .do((res: Response ) => console.log(res.json()))
              .map((res: Response ) => res.json());
}



public postAccountNewsLetter(newsletterConcernEmail) {
      const headers1 =  new Headers({ 'Access-Control-Allow-Origin': '*' });
const options = new RequestOptions({  headers: headers1 });
      const object = {
        email: newsletterConcernEmail,
       };
      const url = this.beginUrl + '?newsletterConcernEmail=' + newsletterConcernEmail;
    const url1 = 'http://127.0.0.1:8080/orientation/surfer/inscriptionToNewsletter' +
     '?newsletterConcernEmail=' + newsletterConcernEmail;

      const url2 = 'https://jsonplaceholder.typicode.com/posts';
    return  this.http.post(url1, object, options)
              .do((res: Response ) => console.log(res.json()))
              .map((res: Response ) => res.json());
}



 // gestion de la connexion et de la deconnexion

 public login(email, password) {
    const headers1 =  new Headers({ 'Access-Control-Allow-Origin': '*' });
const options = new RequestOptions({  headers: headers1 });
      const object = {
        login: email,
        motDePasse: password,
       };
const url = this.beginUrl+'/orientation/customer/authentication'+'?login='+email+'&password='+password ;  
    return this.http.post(url,object,options)
    .map(res => res.json()).map((res) => {
        if (res.success) {
          localStorage.setItem('auth_token', res.auth_token);
          this.loggedIn = true;
        }

        return res.success;
      });
  }

  logout() {
    localStorage.removeItem('auth_token');
    this.loggedIn = false;
  }

  isLoggedIn() {
    return this.loggedIn;
  }
}
