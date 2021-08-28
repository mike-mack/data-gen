package writers

import scala.collection.mutable.ArrayBuffer
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import models._

class JsonWriterSpec extends AnyFlatSpec with Matchers {
    "The JsonWriter class" should "return a Jsonified ArrayBuffer" in {
        val person = Person("firstname", "lastname")
        val input = ArrayBuffer(person)
        val writer = new JsonWriter()
        val output = writer.writeOutput(input)
        assert(output.isInstanceOf[String])
    }
}









// class PropsSpec extends AnyFlatSpec with Matchers {
//     "The Props object" should "return an instance of java.util.Properties" in {
//         val p: Properties = Props.getProps("development.properties")
//         assert(p.getProperty("batchSize").toInt == 100)
//     }
// }



// class JsonWriter extends Writer {
//     def writeOutput(content: ArrayBuffer[Person]): Unit = {
//         val g = new Gson
//         val jsonString = g.toJson(content)
//         println(jsonString)
//         jsonString
//     }
// }
