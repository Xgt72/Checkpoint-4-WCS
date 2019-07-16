import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PerformanceService {

  constructor(private myService: HttpClient) { }

  getAllPerformances(): Observable<any> {
    return this.myService.get(
      environment.domain + "/performance"
    );
  }

  addPerformance(performance: Performance): Observable<any> {
    return this.myService.post(
      environment.domain + "/performance",
      performance
    );
  }

  updatePerformance(performance: Performance, id: string): Observable<any> {
    return this.myService.put(
      environment.domain + "/performance/" + id,
      performance
    );
  }

  deletePerformance(id: string): Observable<any> {
    return this.myService.delete(
      environment.domain + "/performance/" + id
    );
  }
}
