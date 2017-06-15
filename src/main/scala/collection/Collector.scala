package collection

import domain.{CollectedValues, RecognizedValue, Value}

object Collector {
  def map(values: List[RecognizedValue]): CollectedValues = CollectedValues(values.map(v => Value(v.value.label, v.value.value)))
}
