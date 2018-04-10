import io.circe.generic.extras.Configuration
import io.circe.generic.extras.auto._
import io.circe.parser.decode
import org.scalatest.{Matchers, WordSpec}
import io.circe.syntax._
import scala.util.Right

class EventSpec extends WordSpec with Matchers {
  implicit val genDevConfig: Configuration = Configuration.default.withDiscriminator("what_am_i")
  "decode" should {
    "parse foo" in {
      decode[Event]("""{"i":1,"what_am_i":"Foo"}""") should be(Right(Foo(1)))
    }
    "parse bar" in {
      decode[Event]("""{"s":"blah","what_am_i":"Bar"}""") should be(Right(Bar("blah")))
    }
    "parse baz" in {
      decode[Event]("""{"c":"a","what_am_i":"Baz"}""") should be(Right(Baz('a')))
    }
    "parse qux" in {
      decode[Event]("""{"values":["abc","def","ghi"],"what_am_i":"Qux"}""") should be(Right(Qux(List("abc", "def", "ghi"))))
    }
  }
  "encode" should {
    "produce foo json" in {
      (Foo(1): Event).asJson.noSpaces should be("""{"i":1,"what_am_i":"Foo"}""")
    }
    "produce bar json" in {
      (Bar("blah"): Event).asJson.noSpaces should be("""{"s":"blah","what_am_i":"Bar"}""")
    }
    "produce baz json" in {
      (Baz('a'): Event).asJson.noSpaces should be("""{"c":"a","what_am_i":"Baz"}""")
    }
    "produce qux json" in {
      (Qux(List("abc", "def", "ghi")): Event).asJson.noSpaces should be("""{"values":["abc","def","ghi"],"what_am_i":"Qux"}""")
    }
  }

}
