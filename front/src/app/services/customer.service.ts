import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from '../models/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private myService: HttpClient) { }

  getCustomertById(customerId: number): Observable<any> {
    return this.myService.get(
      environment.domain + "/customer/" + customerId
    );
  }

  addCustomer(customer: Customer): Observable<any> {
    return this.myService.post(
      environment.domain + "/customer",
      customer
    );
  }

  updateCustomerById(id: number, customer: Customer): Observable<any> {
    return this.myService.put(
      environment.domain + "/customer/" + id,
      customer
    );
  }

  deleteCart(id: number): Observable<any> {
    return this.myService.delete(
      environment.domain + "/customer/" + id
    );
  }
}
