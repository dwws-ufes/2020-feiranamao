import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AccountService } from './account.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  public formLogin =  new FormGroup ({
    name: new FormControl(),
    password: new FormControl()
  });
  showError: boolean | undefined;
  loginIsOk: boolean | undefined;
  constructor(
    private fb: FormBuilder,
    private cd: ChangeDetectorRef,
    private router: Router,
    private accountService: AccountService
  ) {
    //translate.setDefaultLang('pt-br');
  }

  ngOnInit() {
    this.buildForm();
  }

  OnChanges() {
    this.cd.detectChanges();
  }

  buildForm() {
  this.formLogin = this.fb.group({
      'login': [null, Validators.compose([Validators.required])],
      'senha': [null, Validators.compose([Validators.required, Validators.min(4)])],
    });
  }

  // validLogin() {
  // this.router.navigate(['dashboard']);
  // const user: UserAccountViewModel = new UserAccountViewModel(this.form.value);
  // }

  validLogin() {

    this.accountService.authenticationService(this.formLogin.value.login, this.formLogin.value.senha)
    .subscribe((response: any) => {

      console.log(response);

      this.router.navigate(['/perfil']);

   /* this.accountService.authLogin(user).subscribe((response: any) => {
      if (response.status === '1') {
       localStorage.setItem('jsessionid', response.responseBody.jsessionid.$);
        localStorage.setItem('isAuthenticado', 'S');
        localStorage.setItem('user', user.email);
        const tokenData = new TokenViewModel(response.responseBody.loginresponse);
         localStorage.setItem('tokenData', JSON.stringify(tokenData));

   }*/
      //this.showError = true;
    });
  }
}
