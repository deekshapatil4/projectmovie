import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject ,Observable} from 'rxjs';
import { Cart } from '../shared/Cart';
import { CartItem } from '../shared/CartItem';
import { Movie } from '../shared/Movie';

@Injectable({
  providedIn: 'root'
})
export class CartService {
private cart:Cart=new Cart();
private cartSubject:BehaviorSubject<Cart>=new BehaviorSubject(this.cart)
  constructor(private http:HttpClient) { }
  bookticket(movie:Movie):void{
    let cartItem=this.cart.items.find(item=>item.movie.mid===movie.mid)
   if(cartItem)
     return;

   this.cart.items.push(new CartItem(movie));
   this.setCartToLocalStorage();
  }
    //Remove from add TO Cart
    removeFromCart(moviemid:string):void{
      this.cart.items=this.cart.items.filter(item=>item.movie.mid !=moviemid)
      this.setCartToLocalStorage();

    }
      //change quantity
  changeQuantity(moviemid:string ,quantity:number){
    let cartItem=this.cart.items.find(item=>item.movie.mid===moviemid);
    if(!cartItem)

    return;
    cartItem.quantity=quantity;
    cartItem.price=quantity*cartItem.movie.price;
    this.setCartToLocalStorage();
  }
    //clear Cart
    clearCart(){
      this.cart=new Cart();
      this.setCartToLocalStorage()
    }
    //store cart details
    getCartObservable():Observable<Cart>{
      return this.cartSubject.asObservable();

    }
   //set local storage
   private setCartToLocalStorage():void{
    this.cart.totalPrice=this.cart.items.reduce((prevSum,currentItem)=>
    prevSum+currentItem.price,0);
    this.cart.totalCount=this.cart.items.reduce((prevSum,currentItem)=>
    prevSum + currentItem.quantity,0)
     const cartJson=JSON.stringify(this.cart);
     localStorage.setItem('Cart',cartJson);
     this.cartSubject.next(this.cart)
  }
  //get the cart details from local Storage
private getCartItemFromLocalStroage():Cart{
  const cartJson=localStorage.getItem('Cart');
  return cartJson?JSON.parse(cartJson):new Cart();

}
}
