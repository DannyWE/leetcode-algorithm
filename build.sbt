name := "leetcode-algorithm"

version := "0.1"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "org.scalatest"                    %% "scalatest"               % "3.0.3"            % "test",
  "org.scalacheck"                   %% "scalacheck"              % "1.13.5"           % "test"
)

libraryDependencies += "org.typelevel" % "cats-core_2.11" % "0.4.0"