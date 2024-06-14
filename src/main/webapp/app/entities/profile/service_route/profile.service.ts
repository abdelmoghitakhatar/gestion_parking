import {Injectable} from "@angular/core";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {ProfileModel} from "../profile.model";
import {map, Observable} from "rxjs";
import {Constants} from "../../../core/Constants";

@Injectable({providedIn: 'root'})
export class ProfileService {

  constructor(private http: HttpClient) {
  }

  get(): Observable<ProfileModel>{
   return this.http
     .get<HttpResponse<ProfileModel>>(`${Constants.baseUrl}/user/profile`, {observe: "response"})
     .pipe(map(res => res.body ?? {}))
  }
}
