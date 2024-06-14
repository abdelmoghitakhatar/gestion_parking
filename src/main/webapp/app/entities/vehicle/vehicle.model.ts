import {ProfileModel} from "../profile/profile.model";
import {TypePlace} from "../enumerations/type-place.model";

export interface VehicleModel {
  id?: number;
  matricule?: string;
  vehicleName?: string;
  permitsType?: TypePlace;
  user?: Pick<ProfileModel, 'id'>;
}
