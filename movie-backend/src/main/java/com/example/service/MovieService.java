package com.example.service;

import java.util.List;

import com.example.entity.Movie;

public interface MovieService {
	//createMovie
public Movie addMovie(Movie m );

//updating movie
public Movie updateMovie(Movie m);

//GeetById
public Movie getMovieById(Long id);

//delete Movie
public void deleteMovie(Long id);

//getAll Movies
public List<Movie> getAllMovies();
//get all Movies under given genre
public List<Movie> getAllMoviesUnderGenere(Long Gid);
//get all Movies under given star
}
