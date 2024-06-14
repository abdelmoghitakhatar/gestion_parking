import { ReservationModel } from "../reservation/reservation.model";

export interface FactureModel {

  id?: number;
  dateFacture?: Date;
  numeroFacture?: string;
  montant?: number
  reservation?: ReservationModel;
}