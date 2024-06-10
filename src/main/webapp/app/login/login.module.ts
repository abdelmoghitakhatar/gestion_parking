import {NgModule} from "@angular/core";
import {SharedModule} from "../shared/shared.module";
import {LOGIN_ROUTE} from "./login.route";
import {RouterModule} from "@angular/router";
import {LoginComponent} from "./login.component";
import { PasswordModule } from 'primeng/password';
import {InputTextModule} from "primeng/inputtext";
import {LoginService} from "./login.service";
import {TokenService} from "./token.service";

@NgModule({
  imports: [
    SharedModule,
    PasswordModule,
    RouterModule.forChild([LOGIN_ROUTE]),
    InputTextModule
  ],
  providers:[LoginService, TokenService],
  declarations: [LoginComponent]
})
export class LoginModule{}
