import { Component, OnInit } from "@angular/core";
import { FormArray, FormGroup } from "@angular/forms";
import { ProfileModel } from "../profile.model";
import { ProfileService } from "../service_route/profile.service";
import { ProfileFormService } from "./profile-form.service";

@Component({
  selector: 'profile',
  templateUrl: 'profile-view.component.html',
  styleUrls: ['profile.component.css']
})
export class ProfileComponent implements OnInit {

  profile!: ProfileModel;
  profileForm: FormGroup = this.profileFormService.create();

  get reservations() {
    return (this.profileForm.get('reservations') as FormArray);
  }

  get vehicles() {
    return (this.profileForm.get('vehicles') as FormArray);
  }

  constructor(
    private profileService: ProfileService,
    private profileFormService: ProfileFormService
  ){}

  ngOnInit(): void {
    this.profileService.get()
      .subscribe({
        next: response => {
          this.profile = response
          this.profileForm = this.profileFormService.create(response);
        },
        error: error => alert(error.message.message)
      })
  }


}
