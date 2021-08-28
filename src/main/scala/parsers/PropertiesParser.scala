package parsers

import scala.io.Source
import java.util.Properties


object Props {
    def getProps(u: String) = {
        val url = getClass.getClassLoader.getResource("development.properties")
        println(url)
        val properties = new Properties()
        val source = Source.fromURL(url)
        properties.load(source.bufferedReader())
        properties
    }



}
