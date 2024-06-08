import {Component, OnInit} from "@angular/core";
import {RegisterModel, UserResponse} from "./register.model";
import {RegisterService} from "./register.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: "signup",
  templateUrl: "register.component.html",
  styleUrls: ["register.component.css"]
})
export class RegisterComponent implements OnInit {

  constructor(
    public registerService: RegisterService
  ){}

  registerForm: FormGroup = new FormGroup({

    firstName: new FormControl(null, {
      validators: [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(25)
      ]
    }),
    lastName: new FormControl(null, {
      validators: [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(25)
      ]
    }),
    password: new FormControl(null, {
      validators: [
        Validators.required,
        Validators.minLength(8)
      ]
    }),
    email: new FormControl(null, {
      validators: [
        Validators.required,
        Validators.email
      ]
    }),
    phone: new FormControl(null, {
      validators: [
        Validators.required,
        Validators.pattern("^((\\+)212|0|00212)[5-8](\\d{2}){4}$")
      ]
    }),
    address: new FormControl(null),
  })

  ngOnInit(): void {
  }

  register(): void {
    this.registerService.signup(this.registerForm.value)
      .subscribe({
        next :response => alert("register successful"),
        error: erreur => alert(erreur.message)
  });
  }

}
