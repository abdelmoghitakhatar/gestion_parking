import {Component, OnInit} from "@angular/core";
import {RegisterModel, UserResponse} from "./register.model";
import {RegisterService} from "./register.service";

@Component({
  selector: "signup",
  templateUrl: "register.component.html",
  styleUrls: ["register.component.css"]
})
export class RegisterComponent implements OnInit {

  user: RegisterModel = new RegisterModel();
  response: UserResponse = new UserResponse();

  constructor(
    public registerService: RegisterService
  ){}

  ngOnInit(): void {
  }

  register(): void {
    this.registerService.signup(this.user)
      .subscribe(response => this.response = response);
  }

  isFormValid(): boolean {
    return (
      !this.user.phone||
      !this.user.address||
      !this.user.firstName||
      !this.user.lastName||
      !this.user.email||
      !this.user.password
    )
  }

}
