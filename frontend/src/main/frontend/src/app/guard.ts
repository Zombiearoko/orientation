import { Component, Directive, Attribute, ElementRef} from '@angular/core';
 //import{ DynamicComponentLoader } from '@angular/core';
//import{ ComponentInstruction } from '@angular/router';
import{ Router,RouterOutlet } from '@angular/router';

@Directive({
    selector: 'router-outlet'
})

export class GuardComponent extends RouterOutlet{
    publicRoutes: any;
    private parentRoute: Router;

   /* constructor(elementRef: ElementRef, parentRoute: Router, @Attribute('email')emailAttr: string,) {
        super(elementRef, parentRoute, emailAttr);
        this.parentRoute = parentRoute;
        this.publicRoutes = {
            'home':true
        };

    }
    /*activate(instruction: ComponentInstruction){
        let url =instruction.urlPath;
        if(!this.publicRoutes[url] && !localStorage.getItem('auth-key')){
            this.parentRoute.navigate(['/home']);
        }
        return super.activate(instruction);

    }*/

}