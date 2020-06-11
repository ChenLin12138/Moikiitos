import { Component, OnInit } from '@angular/core';
import { PlatformLocation } from '@angular/common';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  breadcrumbs : any[];

  isCollapsed = false;

  constructor() { }

  ngOnInit(): void {
    this.breadcrumbs;
  }

}
