package validation

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by GK46IV on 15-6-2017.
  */
class IbanValidatorSpec extends WordSpec with Matchers {

  "IbanValidator" should {

    "have a checkSumCheck method that check an iban" in {
      val goodIban = "DE89370400440532013000"
      IbanValidator.checkSumCheck(goodIban) shouldBe true
    }

    "have a checkSumCheck method identifies a bad iban" in {
      val badIban = "NL12INGB0001230123"
      IbanValidator.checkSumCheck(badIban) shouldBe false
    }


    "have a validate method that validates a correct iban" in {
      val goodIban = "DE89370400440532013000"
      IbanValidator.validate(goodIban) shouldBe Valid
    }

    "have a validate method that validates a bad iban" in {
      val badIban = "NL12INGB0001230123"
      IbanValidator.validate(badIban) shouldBe Invalid
    }
  }
}
