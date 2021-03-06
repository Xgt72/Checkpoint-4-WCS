import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { PerformancesComponent } from './performances/performances.component';
import { BuyTicketsComponent } from './buy-tickets/buy-tickets.component';
import { FindUsComponent } from './find-us/find-us.component';
import { GalleryComponent } from './gallery/gallery.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { LoginComponent } from './login/login.component';
import { MainButtonComponent } from './main-button/main-button.component';
import { SectionTitleComponent } from './section-title/section-title.component';
import { FooterComponent } from './footer/footer.component';
import { TitleComponent } from './title/title.component';

@NgModule({
  declarations: [
    AppComponent,
    AboutUsComponent,
    PerformancesComponent,
    BuyTicketsComponent,
    FindUsComponent,
    GalleryComponent,
    ContactUsComponent,
    NavBarComponent,
    LoginComponent,
    MainButtonComponent,
    SectionTitleComponent,
    FooterComponent,
    TitleComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
