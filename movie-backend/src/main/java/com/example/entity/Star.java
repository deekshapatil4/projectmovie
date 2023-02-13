package com.example.entity;

import java.util.HashSet;
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
@Table(name="star")

public class Star {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="star_id")
		private Long sid;
	
	 private String sname;
	 
		private String simage;
		

	public Star() {
			
		}


	public Long getSid() {
			return sid;
		}


		public void setSid(Long sid) {
			this.sid = sid;
		}


		public String getSname() {
			return sname;
		}


		public void setSname(String sname) {
			this.sname = sname;
		}


		public String getSimage() {
			return simage;
		}


		public void setSimage(String simage) {
			this.simage = simage;
		}


		public Set<Movie> getFiles() {
			return files;
		}


		public void setFiles(Set<Movie> files) {
			this.files = files;
		}
		
		


	public Star(Long sid, String sname, String simage, Set<Movie> files) {
			super();
			this.sid = sid;
			this.sname = sname;
			this.simage = simage;
			this.files = files;
		}




	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(name="movie_star",joinColumns= {
			@JoinColumn(name="star_id")},inverseJoinColumns= {
					@JoinColumn(name="movie_id")
			})
	
	
	 Set<Movie> files=new HashSet<Movie>();


	@Override
	public String toString() {
		return "Star [sid=" + sid + ", sname=" + sname + ", simage=" + simage + ", files=" + files + "]";
	}
	
	
}
