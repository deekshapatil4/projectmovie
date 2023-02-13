package com.example.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.entity.Star;
import com.example.repository.StarRepository;
import com.example.service.StarService;
@Service
public class StarServiceImp implements StarService {
@Autowired
  StarRepository srepo;

@Override
public Star addStar(Star s) {
	return this.srepo.save(s);
}

@Override
public Star updateStar(Star s) {
	return this.srepo.save(s);
	
}

@Override
public Star getStarById(Long id) {
	Optional<Star>s=srepo.findById(id);
	if(s.isPresent()) {
		return s.get();
	}
	throw new RuntimeException("Star not found");
}


@Override
public void deleteStar(Long id) {
	this.srepo.deleteById(id);
	
}

@Override
public List<Star> getAllStars() {
	return this.srepo.findAll() ;
}
}
