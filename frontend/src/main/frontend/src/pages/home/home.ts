import { Component } from '@angular/core';

// import { RegisterPage } from '../register/register';
import { RestProvider } from '../../providers/rest/rest';
@Component({
  selector: 'app-page-home',
  templateUrl: 'home.html'
})
export class HomePageComponent {
public name: string;
  constructor(public rest: RestProvider) {
this.getName();
  }
  public getName() {
    const nom = 'kakeu';
    const prenom = 'linda';
    this.rest.getHello(nom, prenom).subscribe((data) => {
console.log(data);
alert('name: ' + data);
 // nom = data;
});
  }
}
