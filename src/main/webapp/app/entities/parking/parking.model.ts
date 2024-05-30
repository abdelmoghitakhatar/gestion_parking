import {TypePlace} from "../enumerations/type-place.model";

export class ParkingModel {
  constructor(
    public id: number,
    public numPlace: number,
    public typePlace: TypePlace
  ) {
  }
}
