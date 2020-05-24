import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './user/login/login.component';
import { BoardComponent } from './user/board/board.component';

const routes: Routes = [
   { path: '', pathMatch: 'full', redirectTo: '/user/login' }
  ,{ path: 'user/login', component: LoginComponent, pathMatch: 'full' }
  ,{ path: 'user/board', component: BoardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
