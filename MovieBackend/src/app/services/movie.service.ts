import { Injectable } from '@angular/core';

import { HttpClient,HttpParams } from '@angular/common/http';
import { Movie } from '../shared/Movie';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private http:HttpClient) { }

  public getallMovies(){
    return this.http.get("http://localhost:8080/movies/all");
  }
  //get movie by id
  // public getMovieById(moviesmid:string):Observable<any>{
  //   return this.http.get("http://localhost:8080/movies/+mid")
  //   .pipe(map((movies)=>movies===moviesmid)??new Movie());
  // }
   //
   public getMovieById(mid:string):Observable<any>{
    return this.http.get("http://localhost:8080/movies/"+mid)
   }
// post new Movie
   public postMovie(data:any){
    return this.http.post<any>("http://localhost:8080/movies/",data)
    .pipe(map((res:any)=>{
      return res;
    }))
  }
  //getEmployee for admin
  getMovie(){
    return this.http.get<any>("http://localhost:8080/movies/all")
    .pipe(map((res:any)=>{
      return res;
    }))
  }
   //updateMovie
   public updateMovie(data:any ,mid:string){
    return this.http.put<any>("http://localhost:8080/movies/"+mid,data)
    .pipe(map((res:any)=>{
      return res;
    }))
   }

   //delete Movie with Id
   public deleteMovie(mid:string){
    this.http.delete<any>("http://localhost:8080/movies/"+mid)
    .pipe(map((res:any)=>{
      return res;
    }))
   }


}
