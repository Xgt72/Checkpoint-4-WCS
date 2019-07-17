import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-main-button',
  templateUrl: './main-button.component.html',
  styleUrls: ['./main-button.component.css']
})
export class MainButtonComponent implements OnInit {

  public buttonType: string;
  @Input()
  public buttonName: string;
  @Input()
  public buttonDisabled: boolean;

  @Output()
  public setSendOrder: EventEmitter<any> = new EventEmitter();

  constructor() { }

  ngOnInit() {
    if (this.buttonName == "Validate" || this.buttonName == "ENVOYEZ VOTRE CANDIDATURE") {
      this.buttonType = "submit";
    } else {
      this.buttonType = "button";
    }
  }

  onAction() {
    if (this.buttonName == "Validate") {
      this.sendOrder();
    }
  }

  sendOrder() {
    this.setSendOrder.emit(true);
  }

}
