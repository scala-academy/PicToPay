package correction

import domain._
import IbanCorrectionFunctions._

object Corrector {
  def map(values: CollectedValues): CorrectedValues = {
    CorrectedValues(
      values.list.map(v =>
        v.label match {
          case "IBAN" => Value(v.label, v.value.correctIban)
          case _ => Value(v.label, v.value)
        }
      )
    )
  }
}

