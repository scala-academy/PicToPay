package validation

import domain.{CorrectedValues, ValidatedValue, ValidatedValues}

object Validator {
  def map(values: CorrectedValues): ValidatedValues = ValidatedValues(values.list.map(v => ValidatedValue(v.label, v.value, "testStatus")))
}
