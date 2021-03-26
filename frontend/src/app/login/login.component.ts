import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { FormGroup, Validators,FormControl, FormBuilder, ReactiveFormsModule, FormsModule  } from '@angular/forms';
import { UserAccountViewModel } from 'src/app/viewModel/user-account.view-model';
import { Router } from '@angular/router';
import { AccountService } from './account.service';
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  public formLogin =  new FormGroup ({
    name: new FormControl(),
    password: new FormControl()
  });;
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
      'name': [null, Validators.compose([Validators.required])],
      'password': [null, Validators.compose([Validators.required, Validators.min(4)])],
    });
  }

  // validLogin() {
  // this.router.navigate(['dashboard']);
  // const user: UserAccountViewModel = new UserAccountViewModel(this.form.value);
  // }

  validLogin() {
    const user: UserAccountViewModel = new UserAccountViewModel(this.formLogin.value);

    this.accountService.authenticationService(user.email,user.senha)
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
