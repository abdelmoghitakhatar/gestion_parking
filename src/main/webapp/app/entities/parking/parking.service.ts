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
    let headers = new HttpHeaders()
      .append('Authorization', 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhYmRlbG1vZ2hpdC5ha2hhdGFyQGdtYWlsLmNvbSIsImlhdCI6MTcxNzA5Mjk0MSwiZXhwIjoxNzE3MTc5MzQxfQ.uXLVYwzjVJ2qIUWCtivSQvN4Q0iqprJCt_WUICiy1WOUqKhkMdLY21qgCzWv04076otNEGZbPyGQ9s1lcWpQvg');
    return this.http
      .get<ParkingModel[]>(`${Constants.baseUrl}/parking`, {headers: headers});
  }

}
