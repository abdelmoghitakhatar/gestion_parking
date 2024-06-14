import {ProfileModel} from "../profile/profile.model";
import {ParkingModel} from "../parking/parking.model";

export interface ReservationModel {
  id?: number;
  numReservation?: string;
  canceled?: boolean;
  dateDebut?: Date;
  dateFin?: Date;
  facture?: null;
  user?: Pick<ProfileModel, 'id'>;
  parking?: ParkingModel;
}
