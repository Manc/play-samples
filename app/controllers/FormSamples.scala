package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

object FormSamples extends Controller {

	// Case class to hold data of form 1
	case class Form1Data(email: String, age: Int)

	// Form defines the structure of form 1 and basic validation rules
	val form1 = Form(
		mapping(
			"email" -> email,
			"age" -> number(min = 0, max = 100)
		)(Form1Data.apply)(Form1Data.unapply)
	)

	/**
	 * Display HTML form 1
	 */
	def getform1 = Action {
		Ok(views.html.formsamples.form1(form1))
	}

	/**
	 * Handle submission of form 1
	 */
	def postform1 = Action { implicit request =>
		// Validate the form and pass the result to a view
		form1.bindFromRequest.fold(
			formWithErrors => BadRequest(views.html.formsamples.form1(formWithErrors)),
			formData => Ok("OK, the email address is: " + formData.email)
		)
	}




	// Case class to hold data of form 2
	case class Form2Data(username: String, password: String, email: String, terms: Boolean)

	// Form defines the structure of form 2 and basic validation rules
	val form2 = Form(
		mapping(
			"username" -> nonEmptyText(minLength = 3, maxLength = 16),
			"email" -> email,
			"password" -> nonEmptyText(minLength = 5, maxLength = 100),
			"terms" -> checked("Terms must be accepted") // What is the difference to boolean?
		)(Form2Data.apply)(Form2Data.unapply)
	)

	/**
	 * Display a HTML form 2
	 */
	def getform2 = Action {
		Ok(views.html.formsamples.form2(form2))
	}

	/**
	 * Handle submission of form 2
	 */
	def postform2 = Action { implicit request =>
		form2.bindFromRequest.fold(
			formWithErrors => BadRequest(views.html.formsamples.form2(formWithErrors)),
			formData => Ok("Thanks for you signing up!")
		)
	}

}