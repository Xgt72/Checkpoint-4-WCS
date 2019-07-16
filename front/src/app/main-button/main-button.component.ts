import { Component, OnInit, Input } from '@angular/core';

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

  constructor() { }

  ngOnInit() {
    if (this.buttonName == "ENVOYER" || this.buttonName == "ENVOYEZ VOTRE CANDIDATURE") {
      this.buttonType = "submit";
    } else {
      this.buttonType = "button";
    }
  }

}
