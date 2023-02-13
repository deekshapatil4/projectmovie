package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Movie;
import com.example.service.MovieService;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
public class MovieController {
 @Autowired
 private MovieService mservice;
 
 @PostMapping("/")
 //movies/
 public ResponseEntity<Movie> addMovie(@RequestBody Movie m) {
	 return ResponseEntity.ok(this.mservice.addMovie(m));
 }
 
 @PutMapping("/{id}")
 public ResponseEntity<Movie> updateMovie(@PathVariable Long id,@RequestBody Movie m) {
	 m.setMid(id);
	 return ResponseEntity.ok(this.mservice.updateMovie(m));
 }
 // /movies/1
 @GetMapping("/{id}")
 public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id) {
	 return ResponseEntity.ok(this.mservice.getMovieById(id));
 }
 @DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable("id") Long id) {
	 this.mservice.deleteMovie(id);
 }
 @GetMapping("/all")
   public List<Movie> getAllMovies(){
	 return this.mservice.getAllMovies();
 }
 @GetMapping("/genere/{id}")
 public List<Movie> getAllMoviesUnderGenere(@PathVariable("Gid") Long Gid){
	return this.mservice.getAllMoviesUnderGenere(Gid);
 }
}
