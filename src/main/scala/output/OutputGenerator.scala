package output

import domain.ValidatedValues

// creates JSON
object OutputGenerator {
  def map(values: ValidatedValues): String = values.list.toString()
}
