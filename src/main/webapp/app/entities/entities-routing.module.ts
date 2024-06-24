import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AuthGuards } from "../layouts/guards/auth-guard";

const routes: Routes = [
  {
    path: 'profile',
    data: {
      title: 'profile',
    },
    canActivate: [AuthGuards],
    loadChildren: () => import('./profile/profile.module').then(m => m.ProfileModule)
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
})
export class EntitiesRoutingModule {}
