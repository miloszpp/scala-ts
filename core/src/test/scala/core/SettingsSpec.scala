package io.github.scalats.core

import io.github.scalats.tsconfig.{ ConfigFactory, ConfigRenderOptions }

final class SettingsSpec extends org.specs2.mutable.Specification {
  "Settings" title

  import ConfigRenderOptions.concise

  val fullConf = """{"discriminator":"_type","emitCodecs":true,"fieldNaming":"Identity","optionToNullable":true,"optionToUndefined":false,"prependEnclosingClassNames":true,"prependIPrefix":true,"typescriptIndent":"\t","typescriptLineSeparator":";"}"""

  "Fully defined settings" should {
    "be loaded" in {
      val cfg = Settings.load(
        ConfigFactory parseString fullConf,
        Logger(org.slf4j.LoggerFactory getLogger getClass))

      cfg must_=== Settings(typescriptIndent = "\t")
    }

    "be written" in {
      Settings.toConfig(Settings(typescriptIndent = "\t")).
        root().render(concise) must_=== fullConf
    }
  }

  "Settings with custom field naming" should {
    "be loaded" in {
      val source = s"""fieldNaming = "${classOf[CustomFieldNaming].getName}""""

      val cfg = Settings.load(
        ConfigFactory.parseString(source),
        Logger(org.slf4j.LoggerFactory getLogger getClass))

      cfg must_=== Settings(fieldNaming = new CustomFieldNaming)
    }
  }
}

final class CustomFieldNaming extends FieldNaming {
  def apply(tpe: String, property: String): String = s"_${property}"

  override def hashCode: Int = getClass.hashCode

  override def equals(that: Any): Boolean = that match {
    case _: CustomFieldNaming => true
    case _ => false
  }
}