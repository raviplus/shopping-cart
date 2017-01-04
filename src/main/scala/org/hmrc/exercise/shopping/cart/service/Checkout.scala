package org.hmrc.exercise.shopping.cart.service

/**
  * Created by r.radkris on 04/01/2017
  */

import org.hmrc.exercise.shopping.cart.model.ShoppingCart

case class Checkout() {

  def checkout(cart: ShoppingCart): Double = {
    cart.products.view.map {
      case (product, numberOfProductInCart) => numberOfProductInCart * product.price
    }.sum
  }
}
