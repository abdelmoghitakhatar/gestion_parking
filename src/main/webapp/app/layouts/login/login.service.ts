import {Injectable} from "@angular/core";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {LoginModel} from "./login.model";
import {map, Observable, tap} from "rxjs";
import {Constants} from "../../core/Constants";

export type JwtToken = {
  token?: string;
};

@Injectable({
  providedIn: "root"
})
export class LoginService {

  constructor(
    private http: HttpClient
  ) {
  }

  login(info: LoginModel): Observable<JwtToken>{
    return this.http
      .post<HttpResponse<JwtToken>>(`${Constants.baseUrl}/login`, info, {observe: "response"})
      .pipe(map(res => res.body ?? {}));
  }
}
