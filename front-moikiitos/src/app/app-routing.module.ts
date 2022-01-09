import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/user/login/login.component';
import { MainComponent } from './components/main/main.component';
import { AuthGuard } from './auth.guard';
import { ChatComponent } from './components/chat/chat.component';
import { FansComponent } from './components/fans/fans.component';
import { RegisterComponent } from './components/user/register/register.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { TrainComponent } from './components/train/train.component';
import { SalaryComponent } from './components/salary/salary.component';


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
      ,{
        path : 'train'
        , data : { breadcrumb : 'train'}
        , component : TrainComponent
      }
      ,{
        path : 'salary'
        , data : { breadcrumb : 'salary'}
        , component : SalaryComponent
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
      ,{
        path : 'salary',
        component : SalaryComponent
      }
      ,{
        path : 'train',
        component : TrainComponent
      }
    ] 
   }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
