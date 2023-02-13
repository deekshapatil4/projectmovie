package com.example.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Genere;
import com.example.entity.Movie;
import com.example.repository.GenereRepository;
import com.example.repository.MovieRepository;
import com.example.service.MovieService;
@Service
public class MovieServiceImp implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private GenereRepository grepo;
	
	//create
	@Override
	public Movie addMovie(Movie m) {
		return this.movieRepository.save(m);
	}
	//update

	@Override
	public Movie updateMovie(Movie m) {
		return this.movieRepository.save(m);
		
	}
//get
	@Override
	public Movie getMovieById(Long id) {
		 Optional<Movie>m=movieRepository.findById(id);
			if(m.isPresent()) {
				return m.get();
			}
			throw new RuntimeException("Product not found");
	}
//delete
	@Override
	public void deleteMovie(Long id) {
	this.movieRepository.deleteById(id);
		
	}

	@Override
	public List<Movie> getAllMovies() {
      return this.movieRepository.findAll();
	}

	
	@Override
	public List<Movie> getAllMoviesUnderGenere(Long Gid) {
		Genere g=this.grepo.getById(Gid);
//		if(g.isPresent()) {
		List<Movie> movies=g.getMovies();
		return movies;
		
	}

}
