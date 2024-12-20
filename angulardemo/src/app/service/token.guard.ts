import { CanActivateFn } from '@angular/router';

export const tokenGuard: CanActivateFn = (route, state) => {
  return true;
};
