import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";
import { TokenService } from "./token.service";

@Injectable({providedIn: 'root'})
export class AccountService {

    private loggedIn = new BehaviorSubject(this.tokenService.isAuthenticated());

    public authStatus = this.loggedIn.asObservable();

    constructor(
        private tokenService: TokenService
    ){}

    changeStatus(value: boolean){
        this.loggedIn.next(value);
    }

}