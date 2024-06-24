import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AccountService } from "../login/account.service";
import { TokenService } from "../login/token.service";

@Component({
  selector: "navbar",
  templateUrl: "navbar.component.html",
  styleUrls: ["navbar.component.css"]
})
export class NavbarComponent implements OnInit {

  readonly imageUrl: string = "assets/images/home_image.png";
  currentUser: any;

  constructor(
    private accountService: AccountService,
    private tokenService: TokenService,
    private router: Router
  ){}

  ngOnInit(): void {
    this.accountService.authStatus.subscribe(() => {
      this.currentUser = this.tokenService.getInfos();
    });
    console.log('sxwxwx')
  }

  logout(): void {
    this.tokenService.remove();
    this.accountService.changeStatus(false);
    this.router.navigateByUrl('/login');
  }

}
