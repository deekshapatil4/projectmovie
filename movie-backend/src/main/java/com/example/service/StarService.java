package com.example.service;

import java.util.List;


import com.example.entity.Star;

public interface StarService {
	  
	public Star addStar(Star s);
	
	public Star updateStar(Star s);
	 
	public Star getStarById(Long id);
	
	public void deleteStar(Long id);
	
	public List<Star> getAllStars();

}
