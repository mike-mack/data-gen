package writers

import scala.collection.mutable.ArrayBuffer
import com.google.gson.Gson
import models._

class JsonWriter extends Writer {
    def writeOutput(content: ArrayBuffer[Person]): Unit = {
        val g = new Gson
        val jsonString = g.toJson(content)
        println(jsonString)
    }
}
