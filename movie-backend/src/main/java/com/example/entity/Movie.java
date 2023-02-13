package com.example.entity;

import java.time.LocalDate;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity

@Table(name="movie")

public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="movie_id")
	 private Long mid;
	
	 private String mname;
	
	 private String mimage;
	
 private String  mdescription;
  
 private int price;
	
	 private LocalDate release_date;
	 
	
	public Movie() {
		
	}

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMimage() {
		return mimage;
	}

	public void setMimage(String mimage) {
		this.mimage = mimage;
	}

	public String getMdescription() {
		return mdescription;
	}

	public void setMdescription(String mdescription) {
		this.mdescription = mdescription;
	}
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getRelease_date() {
		return release_date;
	}

	public void setRelease_date(LocalDate release_date) {
		this.release_date = release_date;
	}

	public Set<Genere> getGeneres() {
		return generes;
	}

	public void setGeneres(Set<Genere> generes) {
		this.generes = generes;
	}

	public Set<Star> getCast() {
		return cast;
	}

	public void setCast(Set<Star> cast) {
		this.cast = cast;
	}
	

	


	public Movie(Long mid, String mname, String mimage, String mdescription, int price, LocalDate release_date,
			Set<Genere> generes, Set<Star> cast) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mimage = mimage;
		this.mdescription = mdescription;
		this.price = price;
		this.release_date = release_date;
		this.generes = generes;
		this.cast = cast;
	}


	@ManyToMany(cascade=CascadeType.MERGE)
	
	  private Set<Genere> generes=new HashSet<Genere>();

@ManyToMany(cascade=CascadeType.MERGE)
	
	  private Set<Star> cast=new HashSet<Star>();


@Override
public String toString() {
	return "Movie [mid=" + mid + ", mname=" + mname + ", mimage=" + mimage + ", mdescription=" + mdescription
			+ ", price=" + price + ", release_date=" + release_date + ", generes=" + generes + ", cast=" + cast + "]";
}

}
