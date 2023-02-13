import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';
import { MovieService } from 'src/app/services/movie.service';
import { Movie } from 'src/app/shared/Movie';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {
Id:string|null|undefined;
moviedetails!:Movie;
movie!:Movie;
date!:Date;
  constructor(private movieservice:MovieService,private readonly route:ActivatedRoute,private cart:CartService,private router:Router){}
  ngOnInit(): void {
   this.route.paramMap.subscribe
   (
    (params)=>{this.Id=params.get('mid');
    if(this.Id){
      this.movieservice.getMovieById(this.Id).subscribe(

        (moviedata)=>{
          this.moviedetails=moviedata
           return this.moviedetails;

        });
      }
    }
   );
  }
  bookticket(){
    // alert("received");


    this.cart.bookticket(this.moviedetails);
    this.router.navigateByUrl('/book-ticket')
   }

}
