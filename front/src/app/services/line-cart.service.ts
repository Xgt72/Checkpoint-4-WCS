import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LineCart } from '../models/line-cart';

@Injectable({
  providedIn: 'root'
})
export class LineCartService {

  constructor(private myService: HttpClient) { }

  getLineCartByCartId(cartId: number): Observable<any> {
    return this.myService.get(
      environment.domain + "/line-cart-id/" + cartId
    );
  }

  addLineCart(lineCart: LineCart): Observable<any> {
    return this.myService.post(
      environment.domain + "/line-cart",
      lineCart
    );
  }

  updateLineCartById(id: number, lineCart: LineCart): Observable<any> {
    return this.myService.put(
      environment.domain + "/line-cart/" + id,
      lineCart
    );
  }

  deleteLineCart(id: number): Observable<any> {
    return this.myService.delete(
      environment.domain + "/line-cart/" + id
    );
  }

}
