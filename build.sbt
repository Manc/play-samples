name := "play-mongodb-sample"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  cache,
  "org.mongodb" %% "casbah-core" % "2.6.4",
  "com.novus" %% "salat-core" % "1.9.4"
)     

play.Project.playScalaSettings
