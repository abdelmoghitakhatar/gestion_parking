import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {LoginModel} from "./login.model";
import {Observable} from "rxjs";
import {Constants} from "../core/Constants";

@Injectable({
  providedIn: "root"
})
export class LoginService {

  constructor(
    private http: HttpClient
  ) {
  }

  login(info: LoginModel): Observable<string>{
    return this.http
      .post<string>(`${Constants.baseUrl}/login`, info);
  }

}
