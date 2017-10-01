import { NavigationComponent } from './../navigation/navigation.component';
import { FrancPipe } from './../pipes/francPipe';
import { el } from '@angular/platform-browser/testing/src/browser_util';
import { Livre } from './../livre';
import { HttpModule } from '@angular/http';
import { Component, OnInit, Input, ElementRef, ViewChild } from '@angular/core';
import { RestProvider } from '../../providers/rest/rest';
import { HttpClientModule} from '@angular/common/http';
import { Http } from '@angular/http';
/* import {NumberValidator}   from './validators/number.validator';
import {ValidationMessages}   from './validators/validation-messages.component'; */
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { Popup } from 'ng2-opd-popup';
// declare let jsPDF;
import * as jsPDF from 'jspdf';

@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.css', '../../bootstrap/css/bootstrap.css'],
  entryComponents: [NavigationComponent]
})
export class BasketComponent implements OnInit {
  @ViewChild('test') el: ElementRef;
  private total: number;
  private bookName: string;
  basketForm: FormGroup;
   private results: [any];
   private collectionJson: Object;
   submitted = false;
   public beginUrl = 'http://localhost:8092';
isClassVisible: true;
i: any;
key: any;
    heroes = [
    {id: 1, name: 'Superman'},
    {id: 2, name: 'Batman'},
    {id: 5, name: 'BatGirl'},
    {id: 3, name: 'Robin'},
    {id: 4, name: 'Flash'},
     {id: 1, name: 'Superman'},
    {id: 2, name: 'Batman'},
    {id: 5, name: 'BatGirl'},
    {id: 3, name: 'Robin'},
    {id: 4, name: 'Flash'}
];



  constructor(public rest: RestProvider, private builder: FormBuilder, private http: Http, private popup: Popup) {}

   public download() {
       const doc = new jsPDF();
         this.i = 0;
         doc.text(16,10, 'prix');
         doc.text(35,10, 'livre');
        for ( this.key in this.heroes) {
          if (2 === 2) {
           doc.text(20, 20 + this.i, this.heroes[this.key].id + '    ' +  this.heroes[this.key].name );
           this.i = this.i + 10;
        }
          }
        doc.save('Test.pdf');
    }

ngOnInit() {
     this.createForm();
const url2 = 'https://jsonplaceholder.typicode.com/posts';
      this.http.get(url2).subscribe(resp => {
 this.results = resp['results'];
  this.collectionJson = resp.json();
  console.log(this.collectionJson);
});
  }
  createForm() {
    this.basketForm = this.builder.group({
      bookName: ['', Validators.compose([Validators.required])]
    });

  }

  deleteBook(/*index: number*/) {
    this.popup.options = {
color: 'red'
    };
this.popup.show();
   /* this.rest.removeFromBasket(this.bookName)
    .subscribe((data) => {

        this.submitted = true;
       });*/


  }
  addInBasket(post) {
   this.bookName = post.bookName;
      const url = 'http://192.168.8.102:8092/customer/addInBasket' + '?bookName='
    + post.firstNameCustomer;
    const urlSaph = 'http://192.168.8.105:8091/rencontre/Member/registration';
     const urlInno = 'http://localhost:8092/customer/addCustomer';
      const url2 = 'https://jsonplaceholder.typicode.com/post';
 console.log(this.bookName);
this.rest.postBookInBasket(this.bookName)
.subscribe((data) => {

        this.submitted = true;
       });

}
/*updateTotal() {
    this.total = 0;
    for (const element of this.results) {
      this.total += element.id;
    }
}*/

}
