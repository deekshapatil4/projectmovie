package com.example.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="genere")

public class Genere {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="genere_id")
	private Long gid;
	
	 private String gname;
	 
	
	public Genere() {
	
	}


	public Long getGid() {
		return gid;
	}


	public void setGid(Long gid) {
		this.gid = gid;
	}


	public String getGname() {
		return gname;
	}


	public void setGname(String gname) {
		this.gname = gname;
	}


	public List<Movie> getMovies() {
		return movies;
	}


	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	

	public Genere(Long gid, String gname, List<Movie> movies) {
		super();
		gid = gid;
		this.gname = gname;
		this.movies = movies;
	}



	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(name="movie_genere",joinColumns= {
			@JoinColumn(name="genere_id")
	},
	inverseJoinColumns= {
		@JoinColumn(name="movie_id")	
	}
			)
	 List<Movie> movies=new ArrayList<Movie>();


	@Override
	public String toString() {
		return "Genere [Gid=" + gid + ", gname=" + gname + ", movies=" + movies + "]";
	}
	
}
