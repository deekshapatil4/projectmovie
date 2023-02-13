import { Component, OnInit } from '@angular/core';
import { MovieService } from 'src/app/services/movie.service';
import { Movie } from 'src/app/shared/Movie';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {

  moviesList!: Movie[];
  constructor(private movieserive:MovieService){}
 ngOnInit(): void {
   this.movieserive.getallMovies().subscribe((data:any)=>{
    this.moviesList=data;
    return this.moviesList;
   })
 }
}
