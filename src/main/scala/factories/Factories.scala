package factories


import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import java.io.File
import scala.util.Random
import models._


abstract class DataFactory {}


class PersonFactory (val batchSize: Int) extends DataFactory {
    def getFirstNames(): List[String] = {
        val firstNames = Source.fromResource("first.txt").getLines.toList
        firstNames
    }

    def getLastNames(): List[String] = {
        val lastNames = Source.fromResource("last.txt").getLines.toList
        lastNames
    }

    def generateData(): ArrayBuffer[Person] = {
        val firstNames = getFirstNames()
        val lastNames = getLastNames()
        val rand = Random
        val people: ArrayBuffer[Person] = new ArrayBuffer[Person](batchSize)
        for (i <- 1 to batchSize) {
            val first = firstNames(rand.nextInt(firstNames.length - 1))
            val last = lastNames(rand.nextInt(lastNames.length - 1))
            val person = Person(first, last)
            people += person
        }
        people
    }
}


object DataFactory {
    def apply(dataType: String, batchSize: Int) = {
        dataType match {
            case "names" => new PersonFactory(batchSize)
            case _ => throw new Exception("Invalid data type specified")
        }
    }
}
