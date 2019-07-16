export class Performance {
    private title: string;
    private content: string;

    constructor(title: string, content: string) {
        this.title = title;
        this.content = content;
    }

    public getTitle() {
        return this.title;
    }

    public getContent() {
        return this.content;
    }
}
