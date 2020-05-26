import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IconsProviderModule } from './icons-provider.module';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzMenuModule } from 'ng-zorro-antd/menu';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { zh_CN } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import zh from '@angular/common/locales/zh';
import { LoginComponent } from './components/user/login/login.component';
import { JwtModule } from '@auth0/angular-jwt';
import { DashBoardComponent } from './components/dashboard/dashboard.component';


registerLocaleData(zh);

export function tokenGetter() {
  return localStorage.getItem('access_token');
}

//添加路由模块
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashBoardComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    IconsProviderModule,
    NzLayoutModule,
    NzMenuModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule
    ,ReactiveFormsModule
    ,JwtModule.forRoot({
      config : {
        // 从localStorage中获取token
        tokenGetter : tokenGetter
        //允许发送认证的请求域名
        ,whitelistedDomains : ['moikiitos.com']
        //登录接口
        ,blacklistedRoutes : ['moikiitos.com/oauth/token']
      }
    }
    )
  ],
  providers: [{ provide: NZ_I18N, useValue: zh_CN}],
  bootstrap: [AppComponent]
})
export class AppModule { }
