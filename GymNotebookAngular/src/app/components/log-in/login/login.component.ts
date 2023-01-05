import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Login } from 'src/app/interfaces/login';
import { AuthService } from 'src/app/services/auth.service';
import { NotebookService } from 'src/app/services/notebook.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private router: Router, private authService: AuthService, private cookieService: CookieService, private notebookService: NotebookService) {}

  credentials: Login = {
    credentials: this.cookieService.get('username'),
    password: ''
  }

  emailPasswordError: boolean = false;
  visible: boolean = false;

  login() {
    this.authService.login(this.credentials).subscribe( {next: (user) => {
        this.emailPasswordError = false;
        this.cookieService.set('userId', user.userId!.toString(), 365, '/', 'localhost');
        this.cookieService.set('username', user.username, 365, '/', 'localhost');
        this.notebookService.getNotebookByUser(user.userId!).subscribe(notebook => {
          this.cookieService.set('notebookId', notebook.notebookId!.toString(), 365, '/', 'localhost');
           this.router.navigate(['main']);
        })
       
        
      },
      error: (err) => {
        this.emailPasswordError = true;
        this.credentials.password = '';
      }
    })
  }

  show() {
    var password = (<HTMLInputElement>document.getElementById("password_input"))
    if(password!.type === "password") {
      password!.type = "text";
      this.visible = true;
    }else {
      password!.type = "password";
      this.visible = false;
    }
  }
}
