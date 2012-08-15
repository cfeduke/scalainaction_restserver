organization := "com.deploymentzone"

name := "scala-rest"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.1"

seq(webSettings :_*)

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % "2.0.4",
  "org.scalatra" %% "scalatra-scalate" % "2.0.4",
  "org.scalatra" %% "scalatra-specs2" % "2.0.4" % "test",
  "ch.qos.logback" % "logback-classic" % "1.0.0" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "7.6.4.v20120524" % "container",
  "javax.servlet" % "servlet-api" % "2.5" % "provided;container",
  "org.scalaj" %% "scalaj-collection" % "1.2"
)

resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

ivyXML := <dependencies>
      <exclude org="org.eclipse.jetty.orbit" />
    </dependencies>
