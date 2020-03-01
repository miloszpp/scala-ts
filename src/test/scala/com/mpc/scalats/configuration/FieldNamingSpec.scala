package com.mpc.scalats.configuration

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks._

final class FieldNamingSpec extends AnyFlatSpec with Matchers {
  it should "support identity" in {
    import FieldNaming.Identity

    val fixtures = Table(
      "lorem" -> "lorem",
      "fooBar" -> "fooBar",
      "Ipsum" -> "Ipsum"
    )

    forAll(fixtures) { (name, encoded) =>
      Identity(name) should equal(encoded)
    }
  }

  it should "support snake case" in {
    import FieldNaming.SnakeCase

    val fixtures = Table(
      "lorem" -> "lorem",
      "fooBar" -> "foo_bar",
      "Ipsum" -> "Ipsum"
    )

    forAll(fixtures) { (name, encoded) =>
      SnakeCase(name) should equal(encoded)
    }
  }
}
