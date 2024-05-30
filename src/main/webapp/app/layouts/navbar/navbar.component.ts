import {Component, OnInit} from "@angular/core";

@Component({
  selector: "navbar",
  templateUrl: "navbar.component.html",
  styleUrls: ["navbar.component.css"]
})
export class NavbarComponent implements OnInit {

  readonly imageUrl: string = "assets/images/home_image.png";

  ngOnInit(): void {

  }

}
