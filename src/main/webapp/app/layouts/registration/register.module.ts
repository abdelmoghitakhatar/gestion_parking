import {NgModule} from "@angular/core";
import {RegisterComponent} from "./register.component";
import {SharedModule} from "../../shared/shared.module";
import {RouterModule} from "@angular/router";
import {REGISTER_ROUTE} from "./register.route";

@NgModule({
  declarations: [
    RegisterComponent
  ],
  providers: [
  ],
  imports: [
    SharedModule,
    RouterModule.forChild([REGISTER_ROUTE])
  ],
})
export class RegisterModule {}
