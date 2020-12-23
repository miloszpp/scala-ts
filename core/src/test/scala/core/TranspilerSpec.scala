package io.github.scalats.core

import scala.collection.immutable.ListSet

import io.github.scalats.typescript._

import ScalaParserResults._

final class TranspilerSpec extends org.specs2.mutable.Specification {
  "Transpiler" title

  import TranspilerResults._

  val defaultTranspiler: Transpiler = new Transpiler(Settings())

  "Transpiler" should {
    "transpile a case class with one primitive member" in {
      val result = defaultTranspiler(ListSet(caseClass1))

      result must have size 1 and {
        result must contain(interface1)
      }
    }

    "transpile a generic class with one member" in {
      val result = defaultTranspiler(ListSet(caseClass2))

      result must have size 1 and {
        result must contain(interface2)
      }
    }

    "transpile a generic case class with one member list of type parameter" in {
      val result = defaultTranspiler(ListSet(caseClass3))

      result must have size 1 and {
        result must contain(interface3)
      }
    }

    "transpile a generic case class with one optional member" in {
      val result = defaultTranspiler(ListSet(caseClass5))

      result must have size 1 and {
        result must contain(interface5)
      }
    }

    "transpile disjunction types" in {
      val result = defaultTranspiler(ListSet(caseClass7))

      result must have size 1 and {
        result must contain(interface7)
      }
    }

    "transpile Tuple types" in {
      val result = defaultTranspiler(ListSet(caseClass10))

      result must have size 1 and {
        result must contain(interface10)
      }
    }

    "transpile case object" in {
      val result = defaultTranspiler(ListSet(caseObject1))

      result must have size 1 and {
        result must contain(singleton1)
      }
    }

    "correctly transpile object" in {
      val result = defaultTranspiler(
        ListSet(caseObject2),
        Some(InterfaceDeclaration(
          "SupI", ListSet.empty, List.empty[String], Option.empty)))

      result must have size 1 and {
        result must contain(singleton2)
      }
    }

    "correctly transpile sealed trait as union" in {
      val result = defaultTranspiler(ListSet(sealedFamily1))

      result must have size 4 and {
        result must contain(union1)
      } and {
        result must contain(unionMember2Singleton)
      } and {

        val member1Interface = InterfaceDeclaration(
          "IScalaRuntimeFixturesFamilyMember1",
          ListSet(Member("foo", StringRef)),
          List.empty, Some(unionIface))

        result must contain(member1Interface)
      } and {
        result must contain(
          SingletonDeclaration(
            "ScalaRuntimeFixturesFamilyMember3",
            ListSet(Member("foo", StringRef)), Some(unionIface)))
      }
    }
  }
}

object TranspilerResults {
  val interface1 = InterfaceDeclaration(
    "IScalaRuntimeFixturesTestClass1",
    ListSet(Member("name", StringRef)), List.empty, Option.empty)

  val interface2 = InterfaceDeclaration(
    "IScalaRuntimeFixturesTestClass2",
    ListSet(Member("name", SimpleTypeRef("T"))),
    typeParams = List("T"),
    superInterface = Option.empty)

  val interface3 = InterfaceDeclaration(
    "IScalaRuntimeFixturesTestClass3",
    ListSet(Member("name", ArrayRef(SimpleTypeRef("T")))),
    typeParams = List("T"),
    superInterface = Option.empty)

  val interface5 = InterfaceDeclaration(
    "IScalaRuntimeFixturesTestClass5", ListSet(
      Member("counters", MapType(StringRef, NumberRef)),
      Member("name", NullableType(SimpleTypeRef("T")))),
    typeParams = List("T"),
    superInterface = Option.empty)

  val interface7 = InterfaceDeclaration(
    "IScalaRuntimeFixturesTestClass7", ListSet(
      Member("name", UnionType(ListSet(
        CustomTypeRef("IScalaRuntimeFixturesTestClass1", List.empty),
        CustomTypeRef("IScalaRuntimeFixturesTestClass1B", List.empty))))),
    typeParams = List("T"),
    superInterface = Option.empty)

  val interface10 = InterfaceDeclaration(
    "IScalaRuntimeFixturesTestClass10", ListSet(
      Member("tupleC", TupleRef(List(StringRef, StringRef, NumberRef))),
      Member("tupleB", TupleRef(List(StringRef, NumberRef))),
      Member("tupleA", TupleRef(List(StringRef, NumberRef))),
      Member("tuple", TupleRef(List(NumberRef))),
      Member("name", StringRef)),
    typeParams = List.empty,
    superInterface = None)

  val singleton1 = SingletonDeclaration(
    "ScalaRuntimeFixturesTestObject1", ListSet.empty, Option.empty)

  val singleton2 = SingletonDeclaration(
    "ScalaRuntimeFixturesTestObject2", ListSet.empty, Some(
      InterfaceDeclaration("SupI", ListSet.empty, List.empty[String], None)))

  val union1 = UnionDeclaration(
    name = "ScalaRuntimeFixturesFamily",
    fields = ListSet(Member("foo", StringRef)),
    possibilities = ListSet(
      CustomTypeRef("IScalaRuntimeFixturesFamilyMember1", List.empty),
      CustomTypeRef("ScalaRuntimeFixturesFamilyMember2", List.empty),
      CustomTypeRef("ScalaRuntimeFixturesFamilyMember3", List.empty)),
    superInterface = Option.empty)

  val unionIface = InterfaceDeclaration(
    s"IScalaRuntimeFixtures${sealedFamily1.identifier.name}",
    ListSet(Member("foo", StringRef)),
    typeParams = List.empty[String],
    superInterface = Option.empty)

  val unionMember2Singleton = SingletonDeclaration(
    "ScalaRuntimeFixturesFamilyMember2",
    ListSet(Member("foo", StringRef)), Some(unionIface))

}
