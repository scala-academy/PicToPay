package testUtils

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{FlatSpec, GivenWhenThen, Matchers}

abstract class BaseSpec extends FlatSpec with Matchers with GivenWhenThen with ScalaFutures
