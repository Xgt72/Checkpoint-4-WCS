export class Cart {

    private id?: number;
    private customer_id: number;

    constructor(customer_id: number, id?: number) {
        this.id = id;
        this.customer_id = customer_id;
    }

    public getId() {
        return this.id;
    }

    public getCustomerid() {
        return this.customer_id;
    }
}
