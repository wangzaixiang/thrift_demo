name := "thrift-demo"

organization := "waltwang"

libraryDependencies ++= Seq(
  "org.apache.thrift" % "libthrift" % "0.9.0" withSources(),
  "org.slf4j" % "slf4j-simple" % "1.7.5" withSources()
)