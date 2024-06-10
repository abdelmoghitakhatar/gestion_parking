import {Component, OnInit} from "@angular/core";
import {TokenService} from "../login/token.service";
import {Router} from "@angular/router";

@Component({
  selector: "navbar",
  templateUrl: "navbar.component.html",
  styleUrls: ["navbar.component.css"]
})
export class NavbarComponent implements OnInit {

  readonly imageUrl: string = "assets/images/home_image.png";

  constructor(
    private tokenService: TokenService,
    private router: Router
  ){}

  ngOnInit(): void {

  }

  logout(): void {
    this.tokenService.remove();
    this.router.navigateByUrl('login');
  }

}
