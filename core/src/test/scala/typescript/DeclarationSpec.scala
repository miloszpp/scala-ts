package io.github.scalats.typescript

import scala.collection.immutable.Set

import org.specs2.specification.core.Fragments

final class DeclarationSpec extends org.specs2.mutable.Specification {
  "Declaration" title

  "Required types of type declaration" should {
    import io.github.scalats.core.TranspilerResults._

    "be resolved for union type" in {
      union1.requires must_=== Set(
        CustomTypeRef("ScalaRuntimeFixturesFamilyMember1", List.empty),
        CustomTypeRef("ScalaRuntimeFixturesFamilyMember2", List.empty),
        CustomTypeRef("ScalaRuntimeFixturesFamilyMember3", List.empty))
    }

    "be resolved as an empty set for interface" >> {
      Fragments.foreach(Seq[InterfaceDeclaration](
        interface1, interface2, interface3, interface5,
        unionIface, interface10)) { i =>
        i.name in {
          i.requires must beEmpty
        }
      }
    }

    "be resolved for interface" >> {
      interface7.name in {
        interface7.requires must_=== Set(
          CustomTypeRef("ScalaRuntimeFixturesTestClass1", List.empty),
          CustomTypeRef("ScalaRuntimeFixturesTestClass1B", List.empty))
      }
    }

    "be resolved for singleton" >> {
      singleton1.name in {
        singleton1.requires must beEmpty
      }

      singleton2.name in {
        singleton2.requires must_=== Set(CustomTypeRef("SupI", List.empty))
      }
    }
  }
}
