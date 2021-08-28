// import scala.util.Random
// import scala.io.Source
// import scala.collection.mutable.ArrayBuffer
// import java.util.Properties
// import java.io.File
// import play.api.libs.json._


// case class Person(first: String, last: String)

// object Person {
//     def apply(first: String, last: String): Person = {
//         var p = new Person(first, last)
//         p
//     }
// }


// object Hello {

//   def main(args: Array[String]) {
//     val firstNames = Source.fromFile("first.txt").getLines.toList
//     val lastNames = Source.fromFile("last.txt").getLines.toList
//     val rand = Random

//     val defaultBatchSize: String = properties.getProperty("batchSize")
//     val batchSize = options.getOrElse("batch-size", defaultBatchSize)

//     val people: ArrayBuffer[Person] = new ArrayBuffer[Person](batchSize.toString.toInt)
//     // implicit val personWrites = Json.writes[Person]
//     // val personJson: JsValue = Json.toJson(person)


//     for (i <- 1 to batchSize.toString.toInt) {
//         val first = firstNames(rand.nextInt(firstNames.length - 1))
//         val last = lastNames(rand.nextInt(lastNames.length - 1)) 
//         val person = Person(first=first, last=last)
//         people += person
//     }

//     println(people)
//   }
// }