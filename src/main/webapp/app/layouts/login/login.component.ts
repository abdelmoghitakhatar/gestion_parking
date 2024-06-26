import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { MessageService } from "primeng/api";
import { AccountService } from "./account.service";
import { JwtToken, LoginService } from "./login.service";
import { TokenService } from "./token.service";

@Component({
  selector: "login",
  templateUrl: "login.component.html",
  styleUrls: ["login.component.css"]
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup = new FormGroup({
    email: new FormControl(null, {
      validators: [
        Validators.email,
        Validators.required
      ]
    }),
    password: new FormControl(null, {
      validators: [
        Validators.required,
        Validators.minLength(8)
      ]
    }),
  });

  errorLogin: boolean = false;

  constructor(
    private accountService: AccountService,
    private loginService: LoginService,
    private tokenService: TokenService,
    private messageService: MessageService,
    private router: Router
  ){}

  ngOnInit(): void {
  }

  login(): void {
    this.loginService.login(this.loginForm.value).subscribe({
      next: response => this.authenticateSuccess(response),
      error: error => {
        this.errorLogin = true;
        this.showToast(error.error)
      }
    })
}

  authenticateSuccess({token}: JwtToken):void{
    if(token) {
      this.tokenService.handle(token);
      this.accountService.changeStatus(true);
      this.router.navigateByUrl('/');
    }
  }

  showToast(error: any) {
    this.messageService.add(
      {
        severity: 'error',
        summary: 'Erreur',
        detail: error.message
      }
    );
  }

}
