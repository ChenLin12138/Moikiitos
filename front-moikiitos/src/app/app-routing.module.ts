import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';

//路由配置文件
const routes : Routes = [{
  path : 'user/login',
  component : LoginComponent,
  //pathMatch有full和prefix，默认prefix,决定路由匹配策略
  pathMatch: 'full',
},{
  path : '',
  redirectTo : 'user/login',
  pathMatch: 'full',
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
//导出AppRoutingModule并且添加到app.module.ts中
export class AppRoutingModule { }
