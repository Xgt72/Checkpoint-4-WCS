import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ticket } from "../models/ticket";

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  constructor(private myService: HttpClient) { }

  getAllTicketsByPeriod(period: string): Observable<any> {
    return this.myService.get(
      environment.domain + "/ticket-period/" + period
    );
  }

  addTicket(ticket: Ticket): Observable<any> {
    return this.myService.post(
      environment.domain + "/ticket",
      ticket
    );
  }

  updateTicketById(id: number, ticket: Ticket): Observable<any> {
    return this.myService.put(
      environment.domain + "/ticket/" + id,
      ticket
      );
  }

  deleteTicket(id: number): Observable<any> {
    return this.myService.delete(
      environment.domain + "/ticket/" + id
    );
  }
}
