import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/user/login/login.component';
import { MainComponent } from './components/main/main.component';
import { AuthGuard } from './auth.guard';
import { ChatComponent } from './components/chat/chat.component';
import { FansComponent } from './components/fans/fans.component';
import { RegisterComponent } from './components/user/register/register.component';


const routes: Routes = [
   { path: '', pathMatch: 'full', redirectTo: '/user/login' }
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
