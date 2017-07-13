resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"

classpathTypes += "maven-plugin"

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.0")

addSbtPlugin("com.codacy" % "sbt-codacy-coverage" % "1.3.8")

libraryDependencies += "org.bytedeco" % "javacpp" % "1.3"