import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccountService } from '../services/account.service';

@Component({
  selector: 'f-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor(
    private router: Router,
    private accountService: AccountService
  ) { }

  ngOnInit(): void {
  }

  logout() {
    this.accountService.logout();
    this.router.navigate(['/login']);
  }

}
