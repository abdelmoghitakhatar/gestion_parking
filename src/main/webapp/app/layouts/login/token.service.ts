import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root"
})
export class TokenService {

  constructor(

  ) {
  }

  private set(token: string) {
    localStorage.setItem('token', token);
  }

  handle(token: string) {
    this.set(token);
  }

  getToken() {
    return localStorage.getItem('token');
  }

  getInfos(){
    const token = this.getToken();

    if(token){
      const payload = this.payload(token);
      return payload ? payload : null;
    }
    return null;
  }

  remove() {
    localStorage.removeItem('token');
  }

  decode(payload: string) {
    return JSON.parse(atob(payload));
  }

  payload(token: string) {
    const payload: string = token.split('.')[1];
    return this.decode(payload);
  }

  isAuthenticated(): boolean{
    let token = this.getToken();

    if(token){
      let payload = this.payload(token);
      if(new Date().getTime()/1000 <= payload.exp){
        return true;
      }else{
        this.remove();
        return false;
      }
    }
    return false;
  }
}
