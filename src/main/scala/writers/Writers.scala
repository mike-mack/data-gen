package writers

import scala.collection.mutable.ArrayBuffer
import com.google.gson.Gson

import models._

abstract class Writer {
    def writeOutput(content: ArrayBuffer[Person]): String
}


class JsonWriter extends Writer {
    def writeOutput(content: ArrayBuffer[Person]): String = {
        val g = new Gson()
        val jsonString = g.toJson(content)
        jsonString
    }
}


object Writer {
    def apply(fileType: String) = {
        fileType match {
            case "json" => new JsonWriter()
            case _ => throw new Exception("Invalid file type specified")
        }
    }
}