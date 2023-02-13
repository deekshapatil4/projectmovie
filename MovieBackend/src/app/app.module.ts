import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './Mycomponents/header/header.component';

import { HomeComponent } from './pages/home/home.component';
import { AboutComponent } from './pages/about/about.component';
import { MoviesComponent } from './pages/movies/movies.component';

import { HttpClientModule } from '@angular/common/http';

import { MovieDetailsComponent } from './pages/movie-details/movie-details.component';
import { BookTicketComponent } from './pages/book-ticket/book-ticket.component';
import { ConfirmComponent } from './pages/confirm/confirm.component';
import { AdminComponent } from './pages/admin/admin.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,

    HomeComponent,
    AboutComponent,
    MoviesComponent,


    MovieDetailsComponent,
     BookTicketComponent,
     ConfirmComponent,
     AdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
