scalacOptions := Seq("-deprecation", "-unchecked")

organization := "jp.co.dwango"

name := "scalastyle"

scalaVersion := "2.11.1"

crossScalaVersions := Seq("2.11.1", "2.10.2", "2.10.1")

version := "0.3.3"

publishMavenStyle := true

publishTo := Some(Resolver.file("file", new File("target/maven")))

libraryDependencies <<= scalaVersion(v => v match {
  case v211 if v211 startsWith "2.11" => Seq(
    "com.danieltrinh" %% "scalariform" % "0.1.5",
    "org.scalatest" %% "scalatest" % "2.2.0" % "test",
    "com.github.scopt" %% "scopt" % "3.2.0",
    "junit" % "junit" % "4.11" % "test",
    "com.novocode" % "junit-interface" % "0.10" % "test")
  case v210 if v210 startsWith "2.10" => Seq(
    "org.scalariform" %% "scalariform" % "0.1.4",
    "org.scalatest" %% "scalatest" % "2.0.M6-SNAP9" % "test",
    "com.github.scopt" %% "scopt" % "2.1.0",
    "junit" % "junit" % "4.11" % "test",
    "com.novocode" % "junit-interface" % "0.10" % "test")
})

pomExtra :=
<licenses>
  <license>
    <name>Apache 2</name>
    <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
    <distribution>repo</distribution>
  </license>
</licenses>
<developers>
  <developer>
    <id>matthewfarwell</id>
    <name>Matthew Farwell</name>
    <url>http://www.farwell.co.uk</url>
  </developer>
</developers>
