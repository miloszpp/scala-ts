package com.mpc.scalats

import java.time.{Instant, LocalDate}
import java.util.UUID

import com.mpc.scalats.MyEnum.MyEnumType
import com.mpc.scalats.configuration.Config
import com.mpc.scalats.core.TypeScriptGenerator

case class NV(temp: Boolean)

case class SV(a: Int, b: Double, c: Int)

object JTypes {
  type PSV = Either[SV, NV]
}

object MyEnum extends Enumeration {
  type MyEnumType = Value
  val AA: Value = Value(0)
  val BB: Value = Value(1)
  val CC: Value = Value(2)
  val DD: Value = Value(3)
  val EE: Value = Value(4)
}

case class BookDto(title: String, pageCount: Int)

case class AddressDto(street: String, city: String)

case class Both(s: Either[BookDto, AddressDto])

case class Wrapper(s: String) extends AnyVal

case class AuthorDto(id: UUID,
                     name: String,
                     b: Both,
                     c: Wrapper,
                     d: JTypes.PSV,
                     age: Option[Int],
                     mapTest: Map[AddressDto, Option[Int]],
                     address: Either[AddressDto, Option[Int]],
                     nicknames: List[String],
                     workAddress: Option[AddressDto],
                     principal: AuthorDto,
                     books: List[Option[BookDto]],
                     creationDate: Instant,
                     birthday: LocalDate,
                     state: MyEnumType,
                     isRetired: Boolean)

object AuthorExample {

  def main(args: Array[String]) {
    TypeScriptGenerator.generateFromClassNames(
      List("com.mpc.scalats.AuthorDto"))(Config())
  }

}
