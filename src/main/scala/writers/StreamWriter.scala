package writers

import scala.collection.mutable.ArrayBuffer
import models._

class StreamWriter extends Writer {
    def writeOutput(content: ArrayBuffer[Person]): Unit = {
        for (i <- 1 to content.length - 1) {
            println(content(i))
        }
    }
}