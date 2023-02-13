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


import com.example.entity.Star;
import com.example.service.StarService;

@RestController
@RequestMapping("/star")
@CrossOrigin("*")
public class StarController {
	
	@Autowired
	StarService sservice;

	 @PostMapping("/")
	 //star/
	 public ResponseEntity<Star> addStar(@RequestBody Star s) {
		 return ResponseEntity.ok(this.sservice.addStar(s));
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<Star> updateStar(@PathVariable Long id,@RequestBody Star s) {
		 s.setSid(id);
		 return ResponseEntity.ok(this.sservice.updateStar(s));
	 }
	 // /star/1
	 @GetMapping("/{id}")
	 public ResponseEntity<Star> getStarById(@PathVariable("id") Long id) {
		 return ResponseEntity.ok(this.sservice.getStarById(id));
	 }
	 
	 @GetMapping("/all")
	   public List<Star> getAllStars(){
		 return this.sservice.getAllStars();
	 }
				
		 
	 @DeleteMapping("/{id}")
		public void deleteStar(@PathVariable("id") Long id) {
		 this.sservice.deleteStar(id);
	 }
}
