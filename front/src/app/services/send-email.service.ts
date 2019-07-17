import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: 'root'
})
export class SendEmailService {

  constructor(private myService: HttpClient) { }

  public sendOrderEmail(customerId: number, cartId): Observable<any> {
    return this.myService.post(
      environment.domain + "/send-order-email",
      {
        "customer_id": customerId,
        "cart_id": cartId
      }
    );
  }
}
