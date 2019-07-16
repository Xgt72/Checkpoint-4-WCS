import { Component, OnInit } from '@angular/core';
import { Performance } from "../models/performance";
import { PerformanceService } from "../services/performance.service";

@Component({
  selector: 'app-performances',
  templateUrl: './performances.component.html',
  styleUrls: ['./performances.component.css']
})
export class PerformancesComponent implements OnInit {

  private title: string = "Performances";
  public sectionPerformance: Performance[] = null;

  constructor(private performanceService: PerformanceService) { }

  ngOnInit() {
    this.performanceService.getAllPerformances().subscribe(
      (data) => {
        this.sectionPerformance = data;
      }
    )
  }

}
