import {VehicleModel} from "../vehicle/vehicle.model";
import {ReservationModel} from "../reservation/reservation.model";

export interface ProfileModel {
  id?: number;
  userName?: string;
  email?: string;
  firstName?: string;
  lastName?: string;
  phone?: string;
  address?: string;
  vehicles ?: VehicleModel[];
  reservations?: ReservationModel[];

}
