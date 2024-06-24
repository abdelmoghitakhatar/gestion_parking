import { Route } from '@angular/router';
import { LoginGuard } from '../guards/login-guard';
import { RegisterComponent } from "./register.component";

export const REGISTER_ROUTE: Route = {
  path: '',
  component: RegisterComponent,
  data: {
    title: 'signup'
  },
  canActivate: [LoginGuard]
};
