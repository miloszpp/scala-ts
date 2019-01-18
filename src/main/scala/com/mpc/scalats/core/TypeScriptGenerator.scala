package com.mpc.scalats.core

import com.mpc.scalats.configuration.Config

import scala.reflect.runtime.universe._

/**
  * Created by Milosz on 11.06.2016.
  */
object TypeScriptGenerator {

  def generateFromClassNames(
    classNames: List[String],
    logger: Logger,
    classLoader: ClassLoader = getClass.getClassLoader
  )(implicit config: Config) = {
    implicit val mirror = runtimeMirror(classLoader)
    val types = classNames.map { className =>
      println(s"className = $className")
      mirror.staticClass(className).toType
    }

    generate(types, logger)
  }

  def generate(caseClasses: List[Type], logger: Logger)(
    implicit config: Config) = {
    val outputStream = config.outputStream.getOrElse(Console.out)
    val scalaParser = new ScalaParser(logger)
    val scalaTypes = scalaParser.parseTypes(caseClasses)
    val typeScriptInterfaces = Compiler.compile(scalaTypes)

    val emiter = new TypeScriptEmitter(config)

    emiter.emit(typeScriptInterfaces, outputStream)
  }
}
