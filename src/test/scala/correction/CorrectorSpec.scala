package correction

import domain._
import testUtils.BaseSpec
import IbanCorrectionFunctions._

class CorrectorSpec extends BaseSpec {
  val whiteSpaceIban = " NL77 INGB 0123456 78 "
  val correctIban    = "DE89370400440532013000"
  val incorrectIban  = "D3B937O40O4A0S320l30o0 "

  // TODO: check country specific rules!

  "Corrector" should "pick out the IBAN numbers to correct" in {
    val corrected = Corrector.map(CollectedValues(List(
      Value("IBAN", correctIban),
      Value("something else", "useless"))))

    corrected.list.size should be(2)

    corrected.list(0).label should be("IBAN")
    corrected.list(1).label should not be("IBAN")
  }

  it should "remove the white space from an IBAN number" in {
    val corrected = Corrector.map(CollectedValues(List(Value("IBAN", whiteSpaceIban))))

    corrected.list(0).value should be("NL77INGB012345678")
  }

  it should "fix an incorrect IBAN number" in {
    //val newIban = incorrectIban.correctIbanChars

    //println(newIban)
    //newIban should be("tets")
  }
}
