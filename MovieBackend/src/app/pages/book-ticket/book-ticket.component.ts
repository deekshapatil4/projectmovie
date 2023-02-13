import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';
import { Cart } from 'src/app/shared/Cart';
import { CartItem } from 'src/app/shared/CartItem';

@Component({
  selector: 'app-book-ticket',
  templateUrl: './book-ticket.component.html',
  styleUrls: ['./book-ticket.component.css']
})
export class BookTicketComponent implements OnInit {
 cart!:Cart;
  constructor(private cartservice:CartService){
    this.cartservice.getCartObservable()
    .subscribe((cart) => {this.cart = cart;
    })
  }

 ngOnInit(): void {}
  removeFromCart(cartItem:CartItem){
    this.cartservice.removeFromCart(cartItem.movie.mid);
   }
   changeQuantity(cartItem:CartItem,quantityInString:string){
    const quantity=parseInt(quantityInString);
    this.cartservice.changeQuantity(cartItem.movie.mid,quantity);
  }

}


