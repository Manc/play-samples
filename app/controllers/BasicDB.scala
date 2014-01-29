package controllers

import play.api._
import play.api.mvc._

// MongoDB driver
import com.mongodb.casbah.Imports._

// Java's Date class
import java.util.Date


object BasicDB extends Controller {

	def write = Action {
		// Connect to default - localhost, 27017
		val mongoConn = MongoConnection()
		// mongoConn: com.mongodb.casbah.MongoConnection

		// Get the database
		// val mongoDB = mongoConn("sampleapp")
		// mongoDB: com.mongodb.casbah.MongoDB = sampleapp

		// Get the collection
		val mongoColl = mongoConn("sampleapp")("testcoll1")

		/**
		 * The object we intend to write.
		 * Note: There are other ways to create a MongoDBObject, too.
		 * Check out http://api.mongodb.org/scala/casbah/2.0/tutorial.html
		 *
		 * @val MongoDBObject
		*/
		val newObj = MongoDBObject(
			// "_id" of type ObjectId will be created automatically when object is written
			"foo" -> "bar",
			"x" -> "y",
			"pie" -> 3.14,
			"spam" -> "eggs",
			"created" -> new Date() // In the database itself this will become a value of type ISODate (e.g. ISODate("2014-01-29T08:26:38.178Z"))
		)

		// Insert the object
		mongoColl += newObj

		Ok(views.html.basicdb.write(newObj))
	}

}