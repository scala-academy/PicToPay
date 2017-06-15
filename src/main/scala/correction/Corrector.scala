package correction

import domain.{CollectedValues, CorrectedValues}

object Corrector {
  def map(values: CollectedValues): CorrectedValues = CorrectedValues(values.list)
}
