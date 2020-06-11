import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/user/login/login.component';
import { MainComponent } from './components/main/main.component';
import { AuthGuard } from './auth.guard';
import { ChatComponent } from './components/chat/chat.component';
import { FansComponent } from './components/fans/fans.component';
import { RegisterComponent } from './components/user/register/register.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';


const routes: Routes = [
   { path: '', pathMatch: 'full', redirectTo: '/user/login' }
  ,{ path: 'dashboard', component: DashboardComponent, canActivate : [AuthGuard]
    ,children : [
        {
        path : 'chat'
        , data : { breadcrumb : 'chat'}
        ,component : ChatComponent
      }
      ,{
        path : 'fans'
        , data : { breadcrumb : 'fans'}
        , component : FansComponent
      }
    ] 
  }
  ,{ path: 'user/register', component: RegisterComponent, pathMatch: 'full' }
  ,{ path: 'user/login', component: LoginComponent, pathMatch: 'full' }
  ,{ path: 'main', component: MainComponent, canActivate : [AuthGuard]
      ,children : [
       {
        path : 'chat',
        component : ChatComponent
      }
      ,{
        path : 'fans',
        component : FansComponent
      }
    ] 
   }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
