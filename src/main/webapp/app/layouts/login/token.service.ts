import {Injectable} from "@angular/core";

@Injectable({
  providedIn: "root"
})
export class TokenService {

  constructor(

  ) {
  }

  private set(token: string): void{
    localStorage.setItem('token', token);
  }

  handle(token: string): void{
    this.set(token);
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  remove(): void {
    localStorage.removeItem('token');
  }

  decode(payload: string): JSON {
    return JSON.parse(atob(payload));
  }

  payload(token: string): JSON {
    const payload: string = token.split('.')[1];
    return this.decode(payload);
  }
}
