package controllers

import play.api._
import play.api.mvc._

import scala.io.Source
import play.api.libs.json._

object JsonSamples extends Controller {

	def booklist = Action {
		// This import is to bring the current running application into context
		import play.api.Play.current

		// We know the path of our file relative to our app. We get its absolute path back.
		val filename = Play.application.getFile("data/books.json").getAbsolutePath()

		// Read the entire content of the file into a string.
		val fileContents = Source.fromFile(filename).getLines.mkString

		// Parse the JSON encoded string and get a object of type JsValue.
		val json: JsValue = Json.parse(fileContents)

		// Pass json to view
		Ok(views.html.jsonsamples.read(json))
	}

	def bookdetails(id: String) = Action {
		Ok("Book ID: " + id)
	}

}