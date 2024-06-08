import {Component, OnInit} from "@angular/core";
import {ParkingModel} from "../../entities/parking/parking.model";
import {ParkingService} from "../../entities/parking/parking.service";

@Component({
  selector: "home",
  templateUrl: "home.component.html",
  styleUrls: ["home.component.css"]
})
export class HomeComponent implements OnInit{

  parkings?: ParkingModel[];

  constructor(
    private parkingService: ParkingService
  ) {
  }

  ngOnInit(): void {
    this.loadPlaces()
  }

  loadPlaces(): void {
    this.parkingService.get()
      .subscribe({
        next: response => this.parkings = response,
        error: () => alert(`There is an Error, Please Try Later`)
      })
  }

}
