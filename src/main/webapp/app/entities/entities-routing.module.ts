import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  {
    path: 'profile',
    data: {
      title: 'profile',
    },
    loadChildren: () => import('./profile/profile.module').then(m => m.ProfileModule)
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
})
export class EntitiesRoutingModule {}
