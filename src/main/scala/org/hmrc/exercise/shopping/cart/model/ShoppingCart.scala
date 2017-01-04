package org.hmrc.exercise.shopping.cart.model

/**
  * Created by r.radkris on 04/01/2017
  */

case class ShoppingCart(products: Map[Product, Long] = Map.empty) {

  private val priceMap: Map[String, Double] = Map(("apple", 0.60), ("orange", 0.25))

  def addToCart(product: Product) = {
    copy(products + (product -> (products.getOrElse(product, 0L) + 1)))
  }

  def getPrice(product: String): Double = {
    priceMap.getOrElse(product toLowerCase(), 0)
  }
}
