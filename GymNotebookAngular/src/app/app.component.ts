import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'GymNotebookAngular';

  constructor(private router: Router, private location: Location) {}

  activeLink = this.location.path()

  show() {
    console.log(this.activeLink)
  }
}
