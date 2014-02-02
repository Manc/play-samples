package controllers

import play.api._
import play.api.mvc._

// MongoDB driver
import com.mongodb.casbah.Imports._

// Java's Date class
import java.util.Date


object CasbahSamples extends Controller {

	/**
	 * Create document and write it to MongoDB.
	 */
	def write = Action {
		// Connect to MongoDB, database and collection
		val mongoClient = MongoClient("localhost", 27017)
		val db = mongoClient("sampleapp")
		val coll = db("testcoll1")

		/**
		 * The object we intend to write.
		 * Note: There are other ways to create a MongoDBObject, too.
		 * Check out http://api.mongodb.org/scala/casbah/2.0/tutorial.html
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
		coll.insert(newObj)

		Ok(views.html.casbahsamples.write(newObj))
	}


	/**
	 * Read from MongoDB and print results in view.
	 * This example is pretty poor yet, because the results are
	 * converted to a list which is simply printed as one object
	 * which results in a long and ugly JSON string.
	 * Goal: Print results in a HTML table or definition list...
	 */
	def read = Action {
		val mongoClient = MongoClient("localhost", 27017)
		val db = mongoClient("sampleapp")
		val coll = db("testcoll1")

		// First query: count number of documents in collection
		val count: Long = coll.count()

		// Second query: get all documents
		val docs = coll.find() // Type: coll.CursorType
		val list = docs.toList

		Ok(views.html.casbahsamples.read(count, list))
	}

}