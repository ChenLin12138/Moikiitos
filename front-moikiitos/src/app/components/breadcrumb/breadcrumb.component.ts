import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, Params, NavigationEnd, PRIMARY_OUTLET } from '@angular/router';
import { filter } from 'rxjs/operators';

interface IBreadcrumb{
  label: string;
  params: Params;
  url: string;
}

@Component({
  selector: 'app-breadcrumb',
  templateUrl: './breadcrumb.component.html',
  styleUrls: ['./breadcrumb.component.css']
})
export class BreadcrumbComponent implements OnInit {

  public breadcrumbs: IBreadcrumb[];

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { 
    this.breadcrumbs = [];
  }

  ngOnInit(): void {
    // 订阅NavigationEnd事件

    if(event == undefined && null != sessionStorage.getItem('breadcrumbList')){
      console.log(sessionStorage.getItem('breadcrumbList'));
      this.breadcrumbs = JSON.parse(sessionStorage.getItem('breadcrumbList'));
    }

    this.router.events.pipe(filter(event => event instanceof NavigationEnd))
      .subscribe(event => {
        // 设置面包屑
        const root: ActivatedRoute = this.activatedRoute.root;
        console.log('=== janine.树的的根路由', root);
        this.breadcrumbs = this.getBreadcrumbs(root);
        sessionStorage.setItem('breadcrumbList', JSON.stringify(this.breadcrumbs));
      });
  }

  /**
   * 返回表示面包屑的IBreadcrumb对象的数组
   */
  private getBreadcrumbs(route: ActivatedRoute, url: string = '', breadcrumbs: IBreadcrumb[] = []): IBreadcrumb[] {
    const ROUTE_DATA_BREADCRUMB = 'breadcrumb';

    // 得到子路由
    const children: ActivatedRoute[] = route.children;
    console.log('=== janine.有多少子路由 ===', children);

    // 如果没有子路由返回
    if (children.length === 0) {
      console.log('=== janine.没有子路由是 ===', breadcrumbs);
      return breadcrumbs;
    }

    // 遍历每个子元素
    for (const child of children) {
      // 验证主路由
      if (child.outlet !== PRIMARY_OUTLET) {
        continue;
      }

      // 验证路由上指定的自定义数据属性'breadcrumb'
      if (!child.snapshot.data.hasOwnProperty(ROUTE_DATA_BREADCRUMB)) {
        return this.getBreadcrumbs(child, url, breadcrumbs);
      }

      // 获取路由的URL进行分割
      const routeURL: string = child.snapshot.url.map(segment => segment.path).join('/');
      // append route URL to URL 追加路由的url到url
      if (routeURL) {
        console.log('=== janine.routeURL ===', routeURL);
        url += `/${routeURL}`;
      }

      // 添加面包屑
      const breadcrumb: IBreadcrumb = {
        label: child.snapshot.data[ROUTE_DATA_BREADCRUMB],
        params: child.snapshot.params,
        url: url
      };
      // 此处的 component 如果为 undefined，可能是因为懒加载，在查找时，没有找到 component 的值，
      // 所以当 component 为 undefined 的时候，就会又往数组里再追加一次，会重复
      if (child.component) {
        breadcrumbs.push(breadcrumb);
      }

      console.log('=== janine.breadcrumbs === ', breadcrumb);

      // 递归
      return this.getBreadcrumbs(child, url, breadcrumbs);
    }
  }

}
