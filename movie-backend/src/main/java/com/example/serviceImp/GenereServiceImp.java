package com.example.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Genere;
import com.example.repository.GenereRepository;
import com.example.service.GenereService;
@Service
public class GenereServiceImp implements GenereService {
@Autowired
GenereRepository grepo;
//addgenere
	@Override
	public Genere addGenere(Genere g) {
		return  this.grepo.save(g);
	}
//update genere
	@Override
	public Genere updateGenere(Genere g) {
		return this.grepo.save(g);
		
	}
// get Genre By id
	@Override
	public Genere getGenereById(Long id) {
		Optional<Genere>g=grepo.findById(id);
		if(g.isPresent()) {
			return g.get();
		}
		throw new RuntimeException("Genere not found");
	}

	@Override
	public void deleteGenere(Long id) {
	this.grepo.deleteById(id);
		
	}
	@Override
	public List<Genere> getAllGeneres() {
		return  this.grepo.findAll();
	}

}
