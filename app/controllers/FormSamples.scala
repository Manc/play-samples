package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

object FormSamples extends Controller {

	// Case class to hold form data
	case class Form1Data(email: String, age: Int)

	// Form defines the structure of the form and basic validation rules
	val form1 = Form(
		mapping(
			"email" -> email,
			"age" -> number(min = 0, max = 100)
		)(Form1Data.apply)(Form1Data.unapply)
	)


	/**
	 * Display a HTML form
	 */
	def getform1 = Action {
		Ok(views.html.formsamples.form1(form1))
	}

	/**
	 * Handle form submission
	 */
	def postform1 = Action { implicit request =>
		// Validate the form and pass the result to a view
		form1.bindFromRequest.fold(
			formWithErrors => BadRequest(views.html.formsamples.form1(formWithErrors)),
			formData => Ok("OK, the email address is: " + formData.email)
		)
	}

}