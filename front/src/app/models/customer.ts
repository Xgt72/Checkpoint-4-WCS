export class Customer {

    private id?: number;
    private firstname: string;
    private lastname: string;
    public email: string;

    constructor(firstname: string, lastname: string, email: string, id?: number) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public getId() {
        return this.id;
    }

    public getFirstname() {
        return this.firstname;
    }

    public getLastname() {
        return this;this.lastname;
    }

    public getEmail() {
        return this.email;
    }
}
