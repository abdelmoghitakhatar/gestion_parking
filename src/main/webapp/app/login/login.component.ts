import {Component, OnInit} from "@angular/core";
import {LoginModel} from "./login.model";
import {LoginService} from "./login.service";

@Component({
  selector: "login",
  templateUrl: "login.component.html",
  styleUrls: ["login.component.css"]
})
export class LoginComponent implements OnInit {

  info: LoginModel = new LoginModel();

  jwt: string = "";

  constructor(
    private loginService: LoginService
  ){}

  ngOnInit(): void {
  }

  login(): void {
    this.loginService.login(this.info).subscribe(response => this.jwt = response);
  }

  isFormValid(): boolean{
    return (
      this.info.username === null || this.info.password === null ||
      this.info.username === '' || this.info.password === ''
    )
  }

}
