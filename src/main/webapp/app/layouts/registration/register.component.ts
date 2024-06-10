import {Component, OnInit} from "@angular/core";
import {RegisterModel, UserResponse} from "./register.model";
import {RegisterService} from "./register.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MessageService} from "primeng/api";
import {Router} from "@angular/router";

@Component({
  selector: "signup",
  templateUrl: "register.component.html",
  styleUrls: ["register.component.css"]
})
export class RegisterComponent implements OnInit {

  constructor(
    public registerService: RegisterService,
    private messageService: MessageService,
    private router: Router
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
        next :response => this.registerSuccess(),
        error: error => {
          this.showToast(error.error, 'error')
        }
      });
  }

  registerSuccess():void{
    this.showToast({message: 'register successful'}, 'success');
    this.router.navigateByUrl('/login');
  }

  showToast(object: any, status: 'error'|'success'):void {
    this.messageService.add(
      {
        severity: status,
        summary: status,
        detail: object.message
      }
    );
  }

}
