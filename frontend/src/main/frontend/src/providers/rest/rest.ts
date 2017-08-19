import { Injectable } from '@angular/core';
import { Response,HttpModule,RequestOptions,RequestMethod,RequestOptionsArgs,Http,Headers } from '@angular/http';
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
	
	public getHello(name,surname){
      let headers1 =  new Headers({ 'Access-Control-Allow-Origin': '*' });
      let options = new RequestOptions({  headers: headers1 });

    let url='http://localhost:8092/hello'+'?name='+name+'&surname='+surname;
    let url2='/api/hello'+'?name='+name+'&surname='+surname;
    let url3="https://jsonplaceholder.typicode.com/post";
    //alert("toto 2"); 
      return  this.http.post(url,options)
              .do((res : Response ) => console.log(res.json()))
              .map((res : Response ) => res.json());
	}

}
