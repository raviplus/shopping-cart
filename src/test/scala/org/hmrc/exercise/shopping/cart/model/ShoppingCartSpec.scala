package org.hmrc.exercise.shopping.cart.model

import org.specs2.mutable.Specification

import org.hmrc.exercise.shopping.cart.model.ShoppingCart
import org.hmrc.exercise.shopping.cart.model.Product
import org.hmrc.exercise.shopping.cart.model.Apple
import org.hmrc.exercise.shopping.cart.model.Orange

/**
  * Created by r.radkris on 04/01/2017
  */

class ShoppingCartSpec extends Specification {

  "Price of an apple is 0.60'" in {
    ShoppingCart().getPrice("apple") must be equalTo 0.60
  }

  "Price of an orange is 0.25'" in {
    ShoppingCart().getPrice("orange") must be equalTo 0.25
  }

  "when adding products to cart should return valid count" should {
    "add one item to cart" in {
      val shoppingCart = ShoppingCart()
        .addToCart(Orange)
        .addToCart(Apple)
      shoppingCart.products.size mustEqual 2
    }
  }

  "when adding different products to cart should update the cart correctly" in {
    val shoppingCart = ShoppingCart().addToCart(Apple)
      .addToCart(Orange)
      .addToCart(Orange)
      .addToCart(Orange)
      .addToCart(Apple)
    shoppingCart.products.size mustEqual 2
    shoppingCart.products mustEqual Map((Apple -> 2), (Orange -> 3))
  }
}

