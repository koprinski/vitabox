name := "vitafu-web"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.0"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

resolvers += "release repository" at "http://chanan.github.io/maven-repo/releases/"

libraryDependencies ++= Seq(javaJdbc,javaEbean,cache,javaWs)

libraryDependencies += "org.apache.xmlrpc" % "xmlrpc" % "3.1.3"

libraryDependencies += "org.apache.xmlrpc" % "xmlrpc-client" % "3.1.3"

libraryDependencies += "com.google.inject" % "guice" % "3.0"

libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.3.5"

libraryDependencies += "io.fastjson" % "boon" % "0.29"

//libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final"

libraryDependencies += javaEbean

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.18"

libraryDependencies += "akkaguice" %% "akkaguice" % "0.8.3"

libraryDependencies += "org.reflections" % "reflections" % "0.9.8"

libraryDependencies += "org.hibernate" % "hibernate-annotations" % "3.5.6-Final"

libraryDependencies += "com.google.code.gson" % "gson" % "2.2.4"
