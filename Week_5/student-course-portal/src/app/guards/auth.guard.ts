import { CanActivateFn } from '@angular/router';

export const AuthGuard: CanActivateFn = (route, state) => {
  const isLoggedIn = true;
  if (!isLoggedIn) { console.log('Access denied'); return false; }
  return true;
};