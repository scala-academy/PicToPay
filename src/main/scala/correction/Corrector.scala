package correction

import domain._

object Corrector {
  def map(values: CollectedValues): CorrectedValues = {
    CorrectedValues(
      values.list.map(v =>
        v.label match {
          case "IBAN" => Value(v.label, correctIban(v.value))
          case _ => Value(v.label, v.value)
        }
      )
    )
  }

  def correctIban(iban: String): String = {
    // remove white space
    correctIbanWhiteSpace(iban)

    //correctIbanWhiteSpace(iban)

    // apply chars -> numbers rules

    // apply numbers -> chars rules

    // use checksum.
    // what happens if no valid IBAN can be found??
  }

  def correctIbanWhiteSpace(iban: String): String = {
    iban.trim.replaceAll(" ", "")
  }

}

