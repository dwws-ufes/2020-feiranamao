import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationService } from 'app/main/apps/auth/auth.service';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Injectable()
export class HttpInterceptorService implements HttpInterceptor {

    constructor(private authenticationService: AuthenticationService,
        private router: Router
        ) { }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
       // if (this.authenticationService.isUserLoggedIn() && req.url.indexOf('basicauth') === -1) {
            if (req.url.indexOf('oauth') === 1) {
                console.log('interceptando basic auth');
                console.log(req.url);

            const authReq = req.clone({
                headers: new HttpHeaders({
                    'Content-Type': 'application/json',
                    'Authorization': this.createBasicAuthToken()
                })
            });
            return next.handle(authReq);
            
        } else {
            console.log('interceptando basic auth');
            console.log(req.url);

        const authReq = req.clone({
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': this.createFullAuthToken()
            })
        });
        return next.handle(authReq);
        } 
        
        if (!this.authenticationService.isUserLoggedIn()) 
        {
            console.log('inteceptando tudo - não autenticado');

            if(!this.authenticationService.isUserLoggedIn()){
                this.router.navigate(['//pages/auth/login-2']);
           }

            return next.handle(req);
        }else{

            console.log('Autenticado');
                console.log('logado: ' + this.authenticationService.getAcessToken());
                return next.handle(req);
        }
    }

    
    createBasicAuthToken() {
        return 'Basic ' + this.authenticationService.getBasicToken()
      }

      createFullAuthToken() {
        return 'Bearer ' + this.authenticationService.getAcessToken()
      }


       
}