import java.io.PrintWriter
import factories._
import parsers._
import writers._


object Main {
    def main(args: Array[String]) {
        val argumentMap: Map[String, String] = ArgumentParser.parseArguments(args)
        val properties = Props.getProps("development.properties")

        val batchSize = argumentMap.getOrElse("batchSize", properties.getProperty("batchSize")).toInt
        val dataType = argumentMap("dataType")
        val fileType = argumentMap("fileType")

        val dataFactory = DataFactory(dataType, batchSize)
        val results = dataFactory.generateData()

        val converter = Writer(fileType)
        val content = converter.writeOutput(results)

        val pw = new PrintWriter("temp.json")
        pw.write(content)
        pw.close()
    }
}



//  new PrintWriter("filename") { write("file contents"); close }



