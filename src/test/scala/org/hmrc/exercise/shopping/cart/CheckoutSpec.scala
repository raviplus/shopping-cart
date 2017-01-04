package org.hmrc.exercise.shopping.cart

import org.hmrc.exercise.shopping.cart.model.{Apple, Orange, ShoppingCart}
import org.hmrc.exercise.shopping.cart.service.Checkout
import org.specs2.mutable.Specification

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

  "total cost must be 0.60 when two apples in the cart" in {
    val shoppingCart = ShoppingCart()
      .addToCart(Apple)
      .addToCart(Apple)
    Checkout().checkoutWithOffers(shoppingCart) mustEqual 0.6
  }

  "total cost must be 1.20 when three apples in the cart" in {
    val shoppingCart = ShoppingCart()
      .addToCart(Apple)
      .addToCart(Apple)
      .addToCart(Apple)
    Checkout().checkoutWithOffers(shoppingCart) mustEqual 1.2
  }

  "total cost must be 1.00 when six oranges found in the cart" in {
    val shoppingCart = ShoppingCart()
      .addToCart(Orange)
      .addToCart(Orange)
      .addToCart(Orange)
      .addToCart(Orange)
      .addToCart(Orange)
      .addToCart(Orange)
    Checkout().checkoutWithOffers(shoppingCart) mustEqual 1.0
  }

  "total cost must be 0.75 when four oranges found in the cart" in {
    val shoppingCart = ShoppingCart()
      .addToCart(Orange)
      .addToCart(Orange)
      .addToCart(Orange)
      .addToCart(Orange)
    Checkout().checkoutWithOffers(shoppingCart) mustEqual 0.75
  }
}

