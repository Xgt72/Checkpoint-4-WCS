import { Component, OnInit } from '@angular/core';
import { TicketService } from "../services/ticket.service";
import { Customer } from '../models/customer';
import { Ticket } from "../models/ticket";
import { CustomerService } from "../services/customer.service";
import { Cart } from '../models/cart';
import { CartService } from "../services/cart.service";
import { LineCartService } from "../services/line-cart.service";
import { LineCart } from '../models/line-cart';
import { SendEmailService } from "../services/send-email.service";

@Component({
  selector: 'app-buy-tickets',
  templateUrl: './buy-tickets.component.html',
  styleUrls: ['./buy-tickets.component.css']
})
export class BuyTicketsComponent implements OnInit {

  private buttonSend: string = "Validate";
  private submitted: boolean = false;
  public adultQuantity: number = 0;
  public childQuantity: number = 0;
  public groupQuantity: number = 0;
  public schoolQuantity: number = 0;
  public day: Date = null;
  public total: number = null;
  public firstname: string = null;
  public lastname: string = null;
  public email: string = null;
  public phone: string = null;
  public tickets: Ticket[] = [];
  public customerId: number = null;
  public cartId: number = null;
  public ticketPeriod: string = null;
  public order: [] = [];
  public adultTicketId: number = null;
  public childTicketId: number = null;
  public groupTicketId: number = null;
  public schoolTicketId: number = null;

  constructor(
    private ticketService: TicketService,
    private customerService: CustomerService,
    private cartService: CartService,
    private lineCartService: LineCartService,
    private sendEmailService: SendEmailService
  ) { }

  ngOnInit() {
  }

  sendOrder(event: boolean, formIsValid: boolean): void {
    if (event && formIsValid) {
      this.addCustomer();
    } else if (event && !formIsValid) {
      this.submitted = true;
    }
  }

  addCustomer() {
    let customer = new Customer(this.firstname, this.lastname, this.email);
    this.customerService.addCustomer(customer).subscribe(
      (data: any) => {
        this.customerId = data.id;
        this.createCart();
      }
    );
  }

  createCart() {
    let cart = new Cart(this.customerId);
    this.cartService.addCart(cart).subscribe(
      (data: any) => {
        this.cartId = data.id;
        this.createLineCart();
      }
    )
  }

  createLineCart() {
    let day = new Date(this.day).getDay();
    if (day == 0 || day == 6 || day == 3) {
      this.ticketPeriod = "weekend";
    } else {
      this.ticketPeriod = "week";
    }
    this.ticketService.getAllTicketsByPeriod(this.ticketPeriod).subscribe(
      (data: any[]) => {
        for (let i = 0; i < data.length; i++) {
          this.tickets.push(new Ticket(data[i].category, data[i].period, data[i].price, data[i].id));
        }
        for (let i = 0; i < this.tickets.length; i++) {
          switch (this.tickets[i].getCategory()) {
            case "Adult":
              this.adultTicketId = this.tickets[i].getId();
              break;
            case "Child":
              this.childTicketId = this.tickets[i].getId();
              break;
            case "Group":
              this.groupTicketId = this.tickets[i].getId();
              break;
            case "School":
              this.schoolTicketId = this.tickets[i].getId();
              break;
            default:
          }
        }
        if (this.adultQuantity != 0) {
          this.lineCartService.addLineCart(new LineCart(this.cartId, this.adultTicketId, this.adultQuantity)).subscribe(
            () => { }
          );
        }
        if (this.childQuantity != 0) {
          this.lineCartService.addLineCart(new LineCart(this.cartId, this.childTicketId, this.childQuantity)).subscribe(
            () => { }
          );
        }
        if (this.groupQuantity != 0) {
          this.lineCartService.addLineCart(new LineCart(this.cartId, this.groupTicketId, this.groupQuantity)).subscribe(
            () => { }
          );
        }
        if (this.schoolQuantity != 0) {
          this.lineCartService.addLineCart(new LineCart(this.cartId, this.schoolTicketId, this.schoolQuantity)).subscribe(
            () => { }
          );
        }
        this.sendEmailService.sendOrderEmail(this.customerId, this.cartId).subscribe(
          (event) => {
            if (event) {
              alert("Your order was sent to the Wild Circus");
            } else {
              alert("Error to send your order !!!");
            }
           }
        );
        
      }
    );



  }

}
