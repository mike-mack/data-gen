package parsers

import java.util.Properties
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class PropsSpec extends AnyFlatSpec with Matchers {
    "The Props object" should "return an instance of java.util.Properties" in {
        val p: Properties = Props.getProps("development.properties")
        assert(p.getProperty("batchSize").toInt == 100)
    }
}


