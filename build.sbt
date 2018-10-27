val groupOfScalaLang = SettingKey[String]("groupOfScalaLang")
val prefixScala = SettingKey[String]("prefixScala")

name := "sKaLa"

version := "1.1"

scalaVersion := "2.12.7" // latest scala stable version at 10/27/2018
sbtVersion := "1.2.6" // latest sbt version at 10/27/2018

prefixScala := "scala"
groupOfScalaLang := s"org.${prefixScala.value}-lang"

autoScalaLibrary := true

libraryDependencies ++= Seq(
  groupOfScalaLang.value % s"${prefixScala.value}-library" % scalaVersion.value,
  groupOfScalaLang.value % s"${prefixScala.value}-reflect" % scalaVersion.value,
  groupOfScalaLang.value % s"${prefixScala.value}-compiler" % scalaVersion.value,
  "org.scalatest" % "scalatest_2.12" % "3.0.5"
)