import {Component, OnInit} from "@angular/core";
import {LoginService} from "./login.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

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
  })

  constructor(
    private loginService: LoginService
  ){}

  ngOnInit(): void {
  }

  login(): void {
    this.loginService.login(this.loginForm.value).subscribe({
      next: response => console.log(response),
      error: erreur => alert(erreur.message)
    })
  }

}
