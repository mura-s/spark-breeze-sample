name := "spark-breeze-sample"

version := "1.0"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core"  % "2.1.0"  % "provided",
  "org.apache.spark" %% "spark-sql"   % "2.1.0"  % "provided",
  "org.apache.spark" %% "spark-mllib" % "2.1.0"  % "provided",
  "com.databricks"   %% "spark-csv"   % "1.5.0",
  "org.scalanlp"     %% "breeze"      % "0.13.1"
)

// sbt-assemblyでtest skip
test in assembly := {}
