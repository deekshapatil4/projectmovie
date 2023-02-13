import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormGroup} from '@angular/forms';
import { MovieService } from 'src/app/services/movie.service';
import { Movie } from 'src/app/shared/Movie';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  formValue !:FormGroup;
  movieModelobj:Movie=new Movie();
  moviedata!:any;
  showAdd!:boolean;
  showUpdate!:boolean;
  constructor(private formbuilder:FormBuilder, private api:MovieService){}
  ngOnInit(): void {
    this.formValue=this.formbuilder.group({
      mname:[''],
      mimage:[''],
      mdescription:[''],
      price:[''],
      mrelease_date:['']

    })
    this.getMovieDetails();
  }
  clickAddMovie(){
    this.formValue.reset();
    this.showAdd=true;
    this.showUpdate=false;
  }
  //posting Movie Details
  postMovieDetails(){
    this.movieModelobj.mname=this.formValue.value.mname;
    this.movieModelobj.mimage=this.formValue.value.mimage;
    this.movieModelobj.mdescription=this.formValue.value.mdescription;
    this.movieModelobj.price=this.formValue.value.price;
    this.movieModelobj.mrelease_date=this.formValue.value.mrelease_date;

     this.api.postMovie(this.movieModelobj)
     .subscribe(res=>{
      console.log(res);
      alert("employee has been added")
      let ref=document.getElementById('cancel')
      ref?.click();
      this.formValue.reset();
      this.getMovieDetails();
     },
     err=>{
      alert("something is wrong");
     })
  }
  getMovieDetails(){
    this.api.getMovie()
    .subscribe(res=>{
      this.moviedata=res;
    })

  }
  deleteMovie(row:any){
    this.api.deleteMovie(row.mid);
    alert("Movie has been deleted ")
    this.getMovieDetails();

  }
  onedit(row:any){
    this.showAdd=false;
    this.showUpdate=true;
    this.movieModelobj.mid=row.mid;
    this.formValue.controls['mname'].setValue(row.mname);
    this.formValue.controls['mimage'].setValue(row.mimage);
    this.formValue.controls['mdescription'].setValue(row.mdescription);
    this.formValue.controls['price'].setValue(row.price);
    this.formValue.controls['mrelease_date'].setValue(row.mrelease_date);
  }
  updateMovieDetails(){
    this.movieModelobj.mname=this.formValue.value.mname;
    this.movieModelobj.mimage=this.formValue.value.mimage;
    this.movieModelobj.mdescription=this.formValue.value.mdescription;
    this.movieModelobj.price=this.formValue.value.price;
    this.movieModelobj.mrelease_date=this.formValue.value.mrelease_date;
    this.api.updateMovie(this.movieModelobj,this.movieModelobj.mid)
    .subscribe(res=>{
      alert("updated successfully");
      let ref=document.getElementById('cancel')
      ref?.click();
      this.formValue.reset();
      this.getMovieDetails();
    })
  }
}
