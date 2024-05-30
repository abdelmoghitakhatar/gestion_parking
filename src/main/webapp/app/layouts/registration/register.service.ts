import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RegisterModel, UserResponse} from "./register.model";
import {Constants} from "../../core/Constants";

@Injectable({
  providedIn: "root"
})
export class RegisterService {

  constructor(private http: HttpClient) {
  }

  signup(user: RegisterModel): Observable<UserResponse> {
    return this.http.post<UserResponse>(`${Constants.baseUrl}/signup`, user);
  }
}
