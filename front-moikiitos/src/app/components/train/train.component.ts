import { Component, OnInit } from '@angular/core';
import { TrainService } from 'src/app/services/train.service';

@Component({
  selector: 'app-train',
  templateUrl: './train.component.html',
  styleUrls: ['./train.component.css']
})
export class TrainComponent implements OnInit {

  info : string ;

  constructor(private trainService : TrainService) {}

  ngOnInit(): void {
    this.trainService.getTrainInfo().subscribe(
      result => {
        this.info =  result.info;
      }
    );
  }

}
