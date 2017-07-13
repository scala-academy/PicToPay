package correction

import domain._
import testUtils.BaseSpec

class CorrectorSpec extends BaseSpec {

  "Corrector" should "correct an incorrect IBAN number" in {
    val iban = "NL77INGB012345678"
    val corrected = Corrector.map(CollectedValues(List(Value("IBAN", iban))))

    corrected.list.size should be(1)
  }
}
