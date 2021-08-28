package models

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class PersonSpec extends AnyFlatSpec with Matchers {
    "The Person model" should "have a first and last name" in {
        val p = new Person(firstName="le first", lastName="name")
        assert(p.firstName == "le first")
        assert(p.lastName == "name")
    }
}
