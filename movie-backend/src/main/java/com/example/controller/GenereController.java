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

import com.example.entity.Genere;

import com.example.service.GenereService;
@RestController
@RequestMapping("/genere")
@CrossOrigin("*")
public class GenereController {
	@Autowired
	GenereService gservice;
	
	 @PostMapping("/")
	 //genere/
	 public ResponseEntity<Genere> addGenere(@RequestBody Genere g) {
		 return  ResponseEntity.ok(this.gservice.addGenere(g));
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<Genere>  updateGenere(@PathVariable Long id,@RequestBody Genere g) {
		 g.setGid(id);
		 return ResponseEntity.ok(this.gservice.updateGenere(g));
	 }
	 // /movies/1
	 @GetMapping("/{id}")
	 public ResponseEntity<Genere>  getGenereById(@PathVariable("id") Long id) {
		 return ResponseEntity.ok(this.gservice.getGenereById(id));
	 }
	 @GetMapping("/all")
	   public List<Genere> getAllGeneres(){
		 return this.gservice.getAllGeneres();
	 }
	 
	 @DeleteMapping("/{id}")
		public void deleteGenere(@PathVariable("id") Long id) {
		 this.gservice.deleteGenere(id);
	 }

}
