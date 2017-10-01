import { HttpModule } from '@angular/http';
import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { RestProvider } from '../../providers/rest/rest';
import { HttpClientModule} from '@angular/common/http';
import { Http } from '@angular/http';
declare let jsPDF;
@Component({
  selector: 'app-librairie',
  templateUrl: './librairie.component.html',
  styleUrls: ['./librairie.component.css', '../../bootstrap/css/bootstrap.css']
})
export class LibrairieComponent implements OnInit {
private results: [any];
   private collectionJson: Object;
   private bookName: string;
   submitted = false;
  public beginUrl = 'http://localhost:8092';

  constructor(public rest: RestProvider, private http: Http) {

  }
  onSubmit() {

  }
public download() {

        const doc = new jsPDF();
        doc.text(20, 20, 'Hello world!');
        doc.text(20, 30, 'This is client-side Javascript, pumping out a PDF.');
        doc.addPage();
        doc.text(20, 20, 'Do you like that?');

        // Save the PDF
        doc.save('Test.pdf');
    }

  ngOnInit() {
    const url = this.beginUrl + '/orientation/customer/researchAllBook';
  const url1 = 'http://localhost:8092/orientation/customer/researchAllBook';
  const url2 = 'https://jsonplaceholder.typicode.com/posts';
      this.http.get(url).subscribe(resp => {
 this.results = resp['results'];
  this.collectionJson = resp.json();
  console.log(this.collectionJson);
});
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
}
