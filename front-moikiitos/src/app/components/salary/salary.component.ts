import { Component, OnInit } from '@angular/core';
import { SalaryService } from 'src/app/services/salary.service';

@Component({
  selector: 'app-salary',
  templateUrl: './salary.component.html',
  styleUrls: ['./salary.component.css']
})
export class SalaryComponent implements OnInit {

  info : string ;

  constructor(private salaryService : SalaryService) {}

  ngOnInit(): void {
    this.salaryService.getSalaryInfo().subscribe(
      result => {
        this.info =  result.info;
      }
    );
  }

}
