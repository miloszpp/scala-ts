organization := "io.github.scala-ts"

name := "sbt-plugin-test-custom-cfg"

version := "1.0-SNAPSHOT"

scalatsEmitClasses := true // By default: false

scalatsPrependIPrefix := true // By default: false (required with scalatsEmitClasses)

// Custom field naming
scalatsFieldNaming := classOf[scalats.CustomFieldNaming]

// Overwrite the directory the printer is initialized with
sourceManaged in scalatsOnCompile := {
  val dir = target.value / "_custom"
  dir.mkdirs()
  dir
}

// Custom printer
scalatsPrinter := scalatsPrinterForClass[scalats.CustomPrinter]()

scalatsPrinterPrelude := scalatsPrinterInMemoryPrelude(
  "import { Option } from 'space-monad'", 
  "// could be useful to import common types")

// Custom type mapper
scalatsTypeScriptTypeMappers := Seq(
  scalatsNullableAsOption, // Also scalatsDateAsString, scalatsNumberAsString
  classOf[scalats.CustomTypeMapper]
)

TaskKey[Unit]("preserveGeneratedTypescript") := {
  import sbt.io.IO
  val logger = streams.value.log

  sys.props.get("scala-ts.sbt-test-temp") match {
    case Some(path) => {
      val tmpdir = new File(path)
      tmpdir.mkdirs()

      val destdir = tmpdir / name.value / "target"
      destdir.mkdirs()

      logger.info(s"Copying directory ${target.value} to ${destdir} ...")

      IO.copyDirectory(target.value, destdir)
    }

    case _ => ()
  }
}
