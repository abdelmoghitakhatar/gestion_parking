import { TypePlace } from "../enumerations/type-place.model";
import { ReservationModel } from "../reservation/reservation.model";

export interface ParkingModel {
  id?: number
  numPlace?: number
  typePlace?: TypePlace
  reservations?: ReservationModel[]
}
