import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/user/login/login.component';
import { DashBoardComponent } from './components/dashboard/dashboard.component';
import { SecondComponent } from './components/second/second.component';
import { MainComponent } from './components/main/main.component';
import { AuthGuard } from './auth.guard';


const routes: Routes = [
   { path: '', pathMatch: 'full', redirectTo: '/user/login' }
  ,{ path: 'user/login', component: LoginComponent, pathMatch: 'full' }
  ,{ path: 'main', component: MainComponent, canActivate : [AuthGuard]
      ,children : [
        {
        path : 'dashboard',
        component : DashBoardComponent
        }
       ,{
         path : 'second',
         component : SecondComponent
       }
    ] 
   }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
