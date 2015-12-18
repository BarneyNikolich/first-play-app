package controllers

import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.Controller
import play.api.mvc.Action
import models.Product
import play.api.Play.current
import play.api.i18n.Messages.Implicits._


class Products extends Controller {

  def list = Action { implicit request =>

    val allProducts = Product.findAll  //returns a list of all the products
    Ok(views.html.products.list(allProducts))
  }

  def showBarcode(code: Long) = Action { implicit request =>

    Product.findByCode(code).map { product =>
      Ok(views.html.products.details(product))
    }.getOrElse(NotFound)
  }

  private val productForm: Form[Product] = Form(
    mapping(
      "code" -> longNumber.verifying(
          "validation.code.duplicate", Product.findByCode(_).isEmpty),
      "name" -> nonEmptyText,
      "description" -> nonEmptyText
      )(Product.apply)(Product.unapply)
    )





}
