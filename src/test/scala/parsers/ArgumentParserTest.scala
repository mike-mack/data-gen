package parsers

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ArgumentParserSpec extends AnyFlatSpec with Matchers {
    "The ArgumentParser object" should "contain key batchSize when that argument is passed" in {
        val testArguments: Array[String] = Array("--batchSize", "10")
        val args = ArgumentParser.parseArguments(testArguments)
        assert(args("batchSize") == 10)
    }

    it should "map an integer value to the batchSize key" in {
        val testArguments: Array[String] = Array("--batchSize", "45")
        val args = ArgumentParser.parseArguments(testArguments)
        val batchSize = args("batchSize")
        assert(batchSize.isInstanceOf[Int])
    }

    it should "throw an exception when an invalid key is provided" in {
        val testArguments: Array[String] = Array("--batchSize", "50", "--fakeArg", "true")
        try {
            val args = ArgumentParser.parseArguments(testArguments)
            // should be unreachable
            assert(false)
        } catch {
            case e: Exception => assert(true)
            case _ : Throwable => assert(false)
        }
    } 
}
