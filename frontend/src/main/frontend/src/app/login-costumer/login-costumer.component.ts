import { HttpModule } from '@angular/http';
import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { RestProvider } from '../../providers/rest/rest';
import { HttpClientModule} from '@angular/common/http';
import { Http } from '@angular/http';
import { RouterModule,Router }   from '@angular/router';



@Component({
  selector: 'app-login-costumer',
  templateUrl: './login-costumer.component.html',
  styleUrls: ['./login-costumer.component.css', '../../bootstrap/css/bootstrap.css']
})
export class LoginCostumerComponent implements OnInit {

  clientForm: FormGroup;
  post: any;
  login: string;
    password: string;
  private results: [any];
   private collectionJson: Object;
   submitted = false;
   collection: any[] = [];
  

  constructor(public rest: RestProvider, public fb: FormBuilder, private http: Http,  private router: Router) {

      this.clientForm = this.fb.group({
      'login': [null, Validators.compose([Validators.email])],
      'password': [null, Validators.compose([Validators.required])],
      });
  }

  onSubmit(post) {
      this.login = post.login;
      this.password = post.password;
this.rest.postLoginCostumer( this.login, this.password)
.subscribe((data) => {
      console.log('*****************Before******************');
       console.log(data);
       this.collection.push(data);
        if(data.status==0){
          this.router.navigate(['/loginCostumer']);
          }
          else{
            if(data.status==1){
               this.router.navigate(['/sessionCostumer']);
            }
              
          }
        this.submitted = true;
       });

  }

  ngOnInit() {
  }

}
