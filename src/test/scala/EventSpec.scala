import org.scalatest.{Matchers, WordSpec}
import scala.util.Right
import io.circe.parser.decode

class EventSpec extends WordSpec with Matchers {
  "decode" should {
    "parse foo" in {
      decode[Event]("""{"i": 1}""") should be(Right(Foo(1)))
    }
    "parse bar" in {
      decode[Event]("""{"s": "blah"}""") should be(Right(Bar("blah")))
    }
    "parse baz" in {
      decode[Event]("""{"c": "a"}""") should be(Right(Baz('a')))
    }
    "parse qux" in {
      decode[Event]("""{"values": ["abc","def","ghi"]}""") should be(Right(Qux(List("abc","def","ghi"))))
    }
  }

}
