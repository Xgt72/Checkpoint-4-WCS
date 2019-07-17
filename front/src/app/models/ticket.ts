export class Ticket {

    private id?: number;
    private category: string;
    private period: string;
    private price: number;

    constructor(category: string, period: string, price: number, id?: number) {
        this.id = id;
        this.category = category;
        this.period = period;
        this.price = price;
    }

    public getId() {
        return this.id;
    }

    public getCategory() {
        return this.category;
    }

    public getPeriod() {
        return this.period;
    }

    public getPrice() {
        return this.price;
    }
}
