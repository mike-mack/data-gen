package writers

import scala.collection.mutable.ArrayBuffer
import models._


trait Writer {
    def writeOutput(content: ArrayBuffer[Person]): Unit
}
