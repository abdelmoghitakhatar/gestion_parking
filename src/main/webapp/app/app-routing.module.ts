import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {NAVBAR_ROUTE} from "./layouts/navbar/navbar.route";

const routes: Routes = [
  {
    path: 'login',
    loadChildren: () => import('./login/login.module').then(m => m.LoginModule),
  },
  {
    path: 'signup',
    loadChildren: () => import('./layouts/registration/register.module').then(m => m.RegisterModule),
  },
  {
    path: '',
    loadChildren: () => import("./entities/entities-routing.module").then(m => m.EntitiesRoutingModule)
  },
  NAVBAR_ROUTE,
  {
    path: '**',
    redirectTo: ''
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
