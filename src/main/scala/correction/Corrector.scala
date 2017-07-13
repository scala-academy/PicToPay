package correction

import domain.{CollectedValues, CorrectedValues}
import scala.io.Source

object Corrector{

  lazy val countryCodes =  Source.fromResource("country-code.txt").getLines().toList.map(_.trim)

  def isCountryCodeValid(code: String): Boolean = countryCodes.contains(code.toUpperCase)

  def map(values: CollectedValues): CorrectedValues = {
    CorrectedValues(values.list)
  }

}
