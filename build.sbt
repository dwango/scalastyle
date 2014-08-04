import AssemblyKeys._

name := "scalastyle"

organization := "jp.co.dwango"

versionWithGit

git.baseVersion := "0.5.0"

scalaVersion := "2.11.1"

crossScalaVersions := Seq("2.11.1", "2.10.2", "2.10.1")

scalacOptions := Seq("-deprecation")

version := "0.3.3"

description := "Scalastyle style checker for Scala"

resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

libraryDependencies ++= Seq(
  "com.danieltrinh" %% "scalariform" % "0.1.5",
  "com.typesafe" % "config" % "1.2.0",
  "junit" % "junit" % "4.11" % "test",
  "org.scalatest" %% "scalatest" % "2.2.0" % "test",
  "com.novocode" % "junit-interface" % "0.10" % "test",
  "org.reflections" % "reflections" % "0.9.9-RC2" % "test" exclude("org.javassist", "javassist") exclude("com.google.guava", "guava"),
  "com.google.guava" % "guava" % "15.0" % "test",
  "org.javassist" % "javassist" % "3.18.2-GA" % "test"
)

fork in Test := true

javaOptions in Test += "-Dfile.encoding=UTF-8"

publishMavenStyle := true

publishTo := Some(Resolver.file("file", new File("target/maven")))

bintrayPublishSettings

bintray.Keys.repository in bintray.Keys.bintray := "scalastyle"

bintray.Keys.bintrayOrganization in bintray.Keys.bintray := Some("scalastyle")

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))

pomIncludeRepository := { _ => false }

pomExtra :=
<licenses>
  <license>
    <name>Apache 2</name>
    <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
    <distribution>repo</distribution>
  </license>
</licenses>
<scm>
  <url>scm:git:git@github.com:scalastyle/scalastyle.git</url>
  <connection>scm:git:git@github.com:scalastyle/scalastyle.git</connection>
</scm>
<developers>
  <developer>
    <id>matthewfarwell</id>
    <name>Matthew Farwell</name>
    <url>http://www.farwell.co.uk</url>
  </developer>
</developers>


assemblySettings

artifact in (Compile, assembly) ~= { art =>
  art.copy(`classifier` = Some("assembly"))
}

addArtifact(artifact in (Compile, assembly), assembly)

mainClass in assembly := Some("org.scalastyle.Main")

buildInfoSettings

sourceGenerators in Compile <+= buildInfo

buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion)

buildInfoPackage := "org.scalastyle"
