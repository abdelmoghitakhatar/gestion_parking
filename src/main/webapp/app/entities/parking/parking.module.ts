import {NgModule} from "@angular/core";
import {ParkingComponent} from "./parking.component";
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  declarations: [
    ParkingComponent
  ],
  exports: [
    ParkingComponent
  ],
  imports: [
    SharedModule,
  ]
})
export class ParkingModule {}
