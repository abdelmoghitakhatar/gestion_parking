import { Component, Input } from "@angular/core";
import { ParkingModel } from "./parking.model";

@Component({
  selector: 'parking',
  templateUrl: 'parking.component.html',
  styleUrls: ['parking.component.css']
})
export class ParkingComponent {

  @Input('parking') parking!: ParkingModel;
  @Input('auth') isAuthenticated: boolean = false;

  protected readonly alert = alert;
}
