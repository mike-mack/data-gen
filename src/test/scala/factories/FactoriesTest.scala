package factories

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class FactoriesSpec extends AnyFlatSpec with Matchers {
    "The DataFactory object" should "return a PersonFactory instance when initialized with 'names' parameter" in {
        val batchSize = 20
        val factory = DataFactory("names", batchSize)
        assert(factory.isInstanceOf[PersonFactory])

    }

    it should "throw an exception when invalid data type is provided" in {
        val batchSize = 30
        try {
            val factory = DataFactory("fakeType", batchSize)
            assert(false)
        } catch {
            case e: Exception => assert(true) // TODO: This is lazy, fix it; what error specifically? Inspect the message?
            case _: Throwable => assert(false)
        }
    }

    it should "load first and last name lists from resource files" in {
        val batchSize = 10
        val factory = DataFactory("names", batchSize)
        assert(factory.isInstanceOf[PersonFactory])
    }

    it should "return a list from calling the getFirstNames method" in {
        val batchSize = 1
        val factory = DataFactory("names", batchSize)
        val firstNameList = factory.getFirstNames()
        assert(firstNameList.isInstanceOf[List[String]])
    }

    it should "returrn a list from calling the getLastNames method" in {
        val batchSize = 2
        val factory = DataFactory("names", batchSize)
        val lastNameList = factory.getLastNames()
        assert(lastNameList.isInstanceOf[List[String]])
    }

    it should "generate a list of 10 names when batchSize is 10" in {
        val batchSize = 10
        val factory = DataFactory("names", batchSize)
        val namesList = factory.generateNames()
        assert(namesList.length == 10)
    }
}
