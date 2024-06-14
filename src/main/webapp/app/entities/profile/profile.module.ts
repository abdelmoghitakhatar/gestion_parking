import {NgModule} from "@angular/core";
import {ProfileComponent} from "./component/profile.component";
import {SharedModule} from "../../shared/shared.module";
import {ProfileRoute} from "./service_route/profile.route";

@NgModule({
  declarations: [
    ProfileComponent
  ],
  imports: [
    SharedModule,
    ProfileRoute
  ],
  exports: [

  ]
})
export class ProfileModule {}
