import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  constructor(private router: Router) {
  }

  links = ['/main/home', '/main/workout', '/main/exercises', '/main/account'];
  activeLink = this.router.url;

  navigate() {
    if(this.activeLink === '/main/home') {
      this.router.navigate(['main/home']);
    }

    if(this.activeLink === '/main/workout') {
      this.router.navigate(['main/workout']);
    }

    if(this.activeLink === '/main/exercises') {
      this.router.navigate(["main/exercises"]);
    }

    if(this.activeLink === '/main/account') {
      this.router.navigate(["main/account"]);
    }
  }
}
