import { Injectable } from "@angular/core";
import { FormArray, FormControl, FormGroup, Validators } from "@angular/forms";
import { FactureModel } from "../../facture/facture.model";
import { ParkingModel } from "../../parking/parking.model";
import { ReservationModel } from "../../reservation/reservation.model";
import { VehicleModel } from "../../vehicle/vehicle.model";
import { ProfileModel } from "../profile.model";

@Injectable({providedIn:'root'})
export class ProfileFormService {

  create(profile: ProfileModel = {}): FormGroup{
    return new FormGroup({
      id: new FormControl(profile.id ?? null,{
        validators: Validators.required
      }),
      firstName: new FormControl(profile.firstName ?? null,{
        validators: Validators.required
      }),
      lastName: new FormControl(profile.lastName ?? null,{
        validators: Validators.required
      }),
      phone: new FormControl(profile.phone ?? null,{
        validators: Validators.required
      }),
      email: new FormControl(profile.email ?? null,{
        validators: Validators.required
      }),
      userName: new FormControl(profile.userName ?? null,{
        validators: Validators.required
      }),
      address: new FormControl(profile.address ?? null,{
        validators: Validators.required
      }),
      reservations: new FormArray(
        profile.reservations ?
        profile.reservations.map(
          item => this.createReservationItem(item)
        ) : [this.createReservationItem({})]
      )
    })
  }

  createReservationItem(reservation: ReservationModel): FormGroup{
    return new FormGroup({
      id: new FormControl(reservation.id ?? null, {

      }),
      numReservation: new FormControl(reservation.numReservation ?? null, {

      }),
      canceled: new FormControl(reservation.canceled ?? null, {

      }),
      dateDebut: new FormControl(reservation.dateDebut ?? null, {

      }),
      dateFin: new FormControl(reservation.dateFin ?? null, {

      }),
      facture: this.createFactureForm(reservation.facture ?? {}),
      parking: this.createParkingForm(reservation.parking ?? {}),
    })
  }

  createVehicleItem(vehicle: VehicleModel): FormGroup{
    return new FormGroup({
      id: new FormControl(vehicle.id ?? null, {

      }),
      matricule: new FormControl(vehicle.matricule ?? null, {

      }),
      permitsType: new FormControl(vehicle.permitsType ?? null, {

      }),
      vehicleName: new FormControl(vehicle.vehicleName ?? null, {

      })
    })
  }

  createFactureForm(facture: FactureModel): FormGroup{
    return new FormGroup({
      id: new FormControl(facture.id, Validators.required),
      numeroFacture: new FormControl(facture.numeroFacture, Validators.required),
      dateFacture: new FormControl(facture.dateFacture, Validators.required),
      montant: new FormControl(facture.montant, Validators.required),
    })
  }

  createParkingForm(parking: ParkingModel): FormGroup{
    return new FormGroup({
      id: new FormControl(parking.id, Validators.required),
      numPlace: new FormControl(parking.numPlace, Validators.required),
      typePlace: new FormControl(parking.typePlace, Validators.required),
    })
  }

}
