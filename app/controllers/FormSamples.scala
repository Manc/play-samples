package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

object FormSamples extends Controller {

	case class Form1Data(email: String, age: Int)

	val form = Form(
		mapping(
			"email" -> nonEmptyText,
			"age" -> number(min = 0, max = 100)
		)(Form1Data.apply)(Form1Data.unapply)
	)


	/**
	 * Display a HTML form
	 */
	def getform1 = Action {
		Ok(views.html.formsamples.getform1(form))
	}

	/**
	 * Handle form submission
	 */
	def postform1 = Action { implicit request =>
		form.bindFromRequest.fold(
			formWithErrors => BadRequest(views.html.formsamples.getform1(formWithErrors)), // BadRequest("Not OK"), 
			formData => Ok("OK, the email address is: " + formData.email)
		)
	}

}