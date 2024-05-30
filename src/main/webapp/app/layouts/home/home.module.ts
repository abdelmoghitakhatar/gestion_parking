import {NgModule} from "@angular/core";
import {HomeComponent} from "./home.component";
import {SharedModule} from "../../shared/shared.module";
import {RouterModule} from "@angular/router";
import {HOME_ROUTE} from "./home.route";
import {ParkingModule} from "../../entities/parking/parking.module";

@NgModule({
    imports: [SharedModule, ParkingModule, RouterModule.forChild([HOME_ROUTE]), ParkingModule],
  declarations: [HomeComponent],
})
export class HomeModule {}
