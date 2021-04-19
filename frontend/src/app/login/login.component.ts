import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AccountService } from '../services/account.service';

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

  validLogin() {

    this.accountService.authenticationService(this.formLogin.value.login, this.formLogin.value.senha)
    .subscribe((response: any) => {
      this.router.navigate(['/page-lojas']);
    });
  }
}
