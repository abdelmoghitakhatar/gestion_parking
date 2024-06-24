import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { InputTextModule } from "primeng/inputtext";
import { PasswordModule } from 'primeng/password';
import { SharedModule } from "../../shared/shared.module";
import { LoginComponent } from "./login.component";
import { LOGIN_ROUTE } from "./login.route";
import { LoginService } from "./login.service";
import { TokenService } from "./token.service";

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
