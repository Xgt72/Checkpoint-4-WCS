export class LineCart {

    private id: number;
    private cart_id: number;
    private ticket_id: number;
    private quantity: number;

    constructor(cart_id: number, ticket_id: number, quantity: number, id?: number) {
        this.id = id;
        this.cart_id = cart_id;
        this.ticket_id = ticket_id;
        this.quantity = quantity;
    }

    public getId() {
        return this.id;
    }

    public getCartId() {
        return this.cart_id;
    }

    public getTicketId() {
        return this.ticket_id;
    }

    public getQuantity() {
        return this.quantity;
    }
}
