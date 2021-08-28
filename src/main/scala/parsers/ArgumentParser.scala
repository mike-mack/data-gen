package parsers

object ArgumentParser {
    val usage = """Usage: data-gen [--batchSize num --dataType name --fileType json]"""
    type OptionMap = Map[String, String]

    def parseArguments(args: Array[String]): OptionMap = {
        if (args.length == 0) println(usage)

        val argsList = args.toList

        def nextOption(map: OptionMap, list: List[String]): OptionMap = {
            def isSwitch(s: String) = (s(0).equals("-"))
            list match {
                case Nil => map
                case "--batchSize" :: value :: tail => nextOption(map ++ Map("batchSize" -> value), tail)
                case "--dataType" :: value :: tail => nextOption(map ++ Map("dataType" -> value), tail)
                case "--fileType" :: value :: tail => nextOption(map ++ Map("fileType" -> value), tail)
                case _ => throw new Exception("Invalid argument passed")
            }
        }
        val options = nextOption(Map(), argsList)
        options
    }
}