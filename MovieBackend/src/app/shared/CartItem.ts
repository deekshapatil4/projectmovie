import { Movie } from "./Movie";

export class CartItem{
  constructor(public movie:Movie){}
  quantity:number=1;
  price:number=this.movie.price;
}

