import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cart } from '../models/cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private myService: HttpClient) { }

  getCartById(cartId: number): Observable<any> {
    return this.myService.get(
      environment.domain + "/cart/" + cartId
    );
  }

  addCart(cart: Cart): Observable<any> {
    return this.myService.post(
      environment.domain + "/cart",
      cart
    );
  }

  updateCartById(id: number, cart: Cart): Observable<any> {
    return this.myService.put(
      environment.domain + "/cart/" + id,
      cart
    );
  }

  deleteCart(id: number): Observable<any> {
    return this.myService.delete(
      environment.domain + "/cart/" + id
    );
  }
}
