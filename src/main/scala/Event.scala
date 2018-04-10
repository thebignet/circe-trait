sealed trait Event

case class Foo(i: Int) extends Event

case class Bar(s: String) extends Event

case class Baz(c: Char) extends Event

case class Qux(values: List[String]) extends Event