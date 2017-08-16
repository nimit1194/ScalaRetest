
lazy val commonSettings = Seq( name := "ScalaRetest",
  version := "1.0",
  scalaVersion := "2.12.2",
  libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.3" % "test",
  libraryDependencies += "org.mindrot" % "jbcrypt" % "0.3m"

)


lazy val accounts = (project in file("accounts"))
  .settings(
    commonSettings
  )
lazy val api_resources = (project in file("api-resources"))
  .settings(
    commonSettings
  )
lazy val checkout = (project in file("checkout"))
  .settings(
    commonSettings
  )

lazy val dashboard = (project in file("dashboard"))
  .settings(
    commonSettings
  )
lazy val inventory = (project in file("inventory"))
  .settings(
    commonSettings
  )


lazy val notification = (project in file("notification"))
  .settings(
    commonSettings
  )

lazy val root = (project in file("."))
    .aggregate(inventory,checkout,dashboard,api_resources,notification,accounts)
  .settings(
    commonSettings
  )