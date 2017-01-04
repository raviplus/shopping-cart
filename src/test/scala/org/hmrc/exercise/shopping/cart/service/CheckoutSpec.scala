package org.hmrc.exercise.shopping.cart.model

import org.specs2.mutable.Specification

import org.hmrc.exercise.shopping.cart.model.ShoppingCart
import org.hmrc.exercise.shopping.cart.model.Product
import org.hmrc.exercise.shopping.cart.model.Apple
import org.hmrc.exercise.shopping.cart.model.Orange
import org.hmrc.exercise.shopping.cart.service.Checkout

/**
  * Created by r.radkris on 04/01/2017
  */

class CheckoutSpec extends Specification {

  "when adding products to shopping cart should return correct count" should {
    "total must be 0 when cart is empty" in {
      Checkout().checkout(ShoppingCart()) mustEqual 0
    }

    "total cost must be 2.05 when two apples and one orange in the cart" in {
      val shoppingCart = ShoppingCart().addToCart(Apple)
        .addToCart(Apple)
        .addToCart(Orange)
        .addToCart(Apple)
      Checkout().checkout(shoppingCart) mustEqual 2.05
    }
  }
}

