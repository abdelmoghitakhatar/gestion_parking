import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {ParkingModel} from "./parking.model";
import {Constants} from "../../core/Constants";

@Injectable({
  providedIn: 'root'
})
export class ParkingService {
  constructor(
    private http: HttpClient
  ){}

  get(): Observable<ParkingModel[]>{
    return this.http
      .get<ParkingModel[]>(`${Constants.baseUrl}/parking`);
  }

}
