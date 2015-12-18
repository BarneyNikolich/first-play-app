package models

/**
 * Created by barn on 18/12/15.
 */
case class Product(code:Long, name: String, description: String)
object Product {

  var products = Set(
    Product(5010255079763L, "Salaomon Speedcross", "Salamon Speedcross 3 - Rockplate and grip"),
    Product(5018206244666L, "Inov-8 X Talons", "Bright orange minimalist shoes, not for long distance"),
    Product(5018306332812L, "Walshes", "A classic lakeland shoe. Hard wearing"),
    Product(5018306312913L, "Inov-8 f-Lite", "A minimalist road shoe. Good for wearing down cartilage")
  )

  def findAll = products.toList.sortBy(_.code)

  def findByCode(code: Long) = products.find(_.code == code)



}
