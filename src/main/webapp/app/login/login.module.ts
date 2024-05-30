import {NgModule} from "@angular/core";
import {SharedModule} from "../shared/shared.module";
import {LOGIN_ROUTE} from "./login.route";
import {RouterModule} from "@angular/router";
import {LoginComponent} from "./login.component";
import { PasswordModule } from 'primeng/password';
import {InputTextModule} from "primeng/inputtext";

@NgModule({
  imports: [
    SharedModule,
    PasswordModule,
    RouterModule.forChild([LOGIN_ROUTE]),
    InputTextModule
  ],
  declarations: [LoginComponent]
})
export class LoginModule{}
