import { inject } from "@angular/core";
import { CanActivateFn, Router } from "@angular/router";
import { AccountService } from "../login/account.service";
import { TokenService } from "../login/token.service";

export const AuthGuards: CanActivateFn = () => {

    let authenticated = inject(TokenService).isAuthenticated();
    if(!authenticated){
        inject(AccountService).changeStatus(false);
        inject(Router).navigateByUrl('/login');
        return false
    }
    return true 
  };