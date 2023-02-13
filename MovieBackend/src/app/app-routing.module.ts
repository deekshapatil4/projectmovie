import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './pages/about/about.component';
import { BookTicketComponent } from './pages/book-ticket/book-ticket.component';
import { ConfirmComponent } from './pages/confirm/confirm.component';

import { HomeComponent } from './pages/home/home.component';
import { MovieDetailsComponent } from './pages/movie-details/movie-details.component';
import { MoviesComponent } from './pages/movies/movies.component';
import { AdminComponent } from './pages/admin/admin.component';

const routes: Routes = [
  {
    path:'',component:HomeComponent
    },
  {
  path:'home',component:MoviesComponent
  },
  {
    path:'about',component:AboutComponent
    },
    {
      path:'movies',component:MoviesComponent
      },

        {
          path:'movies/:mid',component:MovieDetailsComponent
          },
          {
            path:'book-ticket',component:BookTicketComponent
          },
          {
            path:'checkout',component:ConfirmComponent
          },
         { path:'admin' , component:AdminComponent
        }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
