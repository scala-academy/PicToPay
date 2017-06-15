package main.scala

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.easymock.EasyMockSugar
import org.scalatest.{FlatSpec, GivenWhenThen, Matchers}

abstract class BaseSpec extends FlatSpec with Matchers with GivenWhenThen with ScalaFutures
