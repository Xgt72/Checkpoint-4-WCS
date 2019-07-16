import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutUsComponent } from "./about-us/about-us.component";
import { BuyTicketsComponent } from "./buy-tickets/buy-tickets.component";
import { ContactUsComponent } from "./contact-us/contact-us.component";
import { FindUsComponent } from "./find-us/find-us.component";
import { GalleryComponent } from "./gallery/gallery.component";
import { PerformancesComponent } from "./performances/performances.component";
import { LoginComponent } from "./login/login.component";

const routes: Routes = [
  { path: '', redirectTo: 'AboutUs', pathMatch: 'full' },
  { path: 'AboutUs', component: AboutUsComponent },
  { path: 'Performances', component: PerformancesComponent },
  { path: 'BuyTickets', component: BuyTicketsComponent },
  { path: 'FindUs', component: FindUsComponent },
  { path: 'Gallery', component: GalleryComponent },
  { path: 'ContactUs', component: ContactUsComponent },
  { path: 'admin', component: LoginComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { scrollPositionRestoration: 'top'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
