import { inject } from "@angular/core";
import { CanActivateFn, Router } from "@angular/router";
import { TokenService } from "../login/token.service";

export const LoginGuard: CanActivateFn = () => {
    
    let authenticated = inject(TokenService).isAuthenticated();
    if(authenticated){
        inject(Router).navigateByUrl('/');
        return false
    }
    return true 
}