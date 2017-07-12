package validation

import domain.{CorrectedValues, ValidatedValue, ValidatedValues, Value}
import org.scalatest.{Matchers, WordSpec}

class ValidatorSpec extends WordSpec with Matchers {

  "Validator" should {

    "work" in {
      val values = CorrectedValues(List(
        Value("iban", "DE89370400440532013000"),
        Value("iban", "NL12INGB0001230123")
      ))
      Validator.map(values) shouldBe ValidatedValues(List(
        ValidatedValue("iban", "DE89370400440532013000", "Valid"),
        ValidatedValue("iban", "NL12INGB0001230123", "Invalid")
      ))
    }
  }

}
