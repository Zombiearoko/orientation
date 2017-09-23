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

    constructor(public http: Http) {

    }

public getHello(name, surname) {
      const headers1 =  new Headers({ 'Access-Control-Allow-Origin': '*' });
      const options = new RequestOptions({  headers: headers1 });

    const url = 'http://192.168.9.102:8092/hello' + '?name=' + name + '&surname=' + surname;
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
    const url = 'http://192.168.9.102:8092/orientation/administrator/createArticle' +
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
    const url = 'http://192.168.9.102:8092/orientation/surfer/inscription' + '?firstNameCustomer='
    + firstNameCustomer + '&lastNameCustomer=' + lastNameCustomer + '&phoneNumber=' + phoneNumber + '&emailAddress=' + emailAddress
    + '&password =' + password ;
      const url2 = 'https://jsonplaceholder.typicode.com/posts';
      const urlSaph = 'https://www.google.com/url?q=https%3A%2F%2Fafternoon-reaches-41359.herokuapp.com%2Frencontre%2FInternetSurfer%2Fregistration&sa=D&sntz=1&usg=AFQjCNE4MIqkyr7cIswSLCD-1qWTGptEBw';
    return  this.http.post(urlSaph, object, options)
              .do((res: Response ) => console.log(res.json()))
              .map((res: Response ) => res.json());
}

          public postBookInBasket(bookName) {
      const headers1 =  new Headers({ 'Access-Control-Allow-Origin': '*' });
const options = new RequestOptions({  headers: headers1 });
      const object = {
        bookName: bookName,
       };
    const url = 'http://192.168.9.102:8092/customer/addCustomer' + '?firstNameCustomer='
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
    const url = 'http://192.168.9.102:8092/customer/addCustomer' + '?firstNameCustomer='
    + bookName;
      const url2 = 'https://jsonplaceholder.typicode.com/posts';
    return  this.http.post(url, object, options)
              .do((res: Response ) => console.log(res.json()))
              .map((res: Response ) => res.json());
}

 public postLoginCostumer(emailAddress, password) {
      const headers1 =  new Headers({ 'Access-Control-Allow-Origin': '*' });
const options = new RequestOptions({  headers: headers1 });
      const object = {
        email: emailAddress,
        motDePasse: password,
       };
    const url = 'http://192.168.9.102:8092/customer/loginCustomer'  + '?emailAddress=' + emailAddress
    + '&password =' + password ;
      const url2 = 'https://jsonplaceholder.typicode.com/posts';
    return  this.http.post(url2, object, options)
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
    const url = 'http://192.168.9.102:8092/customer/postTestimony' + '?testimonyAuthor=' + testimonyAuthor
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
    const url = 'http://192.168.9.102:8092/orientation/surfer/inscriptionToNewsletter' +
     '?newsletterConcernEmail=' + newsletterConcernEmail;

      const url2 = 'https://jsonplaceholder.typicode.com/posts';
    return  this.http.post(url, object, options)
              .do((res: Response ) => console.log(res.json()))
              .map((res: Response ) => res.json());
}


}
