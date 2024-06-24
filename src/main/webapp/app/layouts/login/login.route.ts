import { Route } from '@angular/router';

import { LoginGuard } from '../guards/login-guard';
import { LoginComponent } from './login.component';

export const LOGIN_ROUTE: Route = {
  path: '',
  component: LoginComponent,
  data: {
    title: 'login'
  },
  canActivate: [LoginGuard]
};
