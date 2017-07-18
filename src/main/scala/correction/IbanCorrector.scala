package correction


class IbanCorrector(val iban: String) {
  def correctIban: String = {
    println("correcting " + iban)
    correctIbanWhiteSpace
  }

  def correctIbanWhiteSpace: String = {
    iban.trim().replaceAll(" ", "")
  }

  val toDigitRules = List(
    '|' -> '1',
    '/' -> '7',
    '!' -> '1',

    'e' -> '3',
    'i' -> '1',
    'o' -> '0',
    'l' -> '1',
    'b' -> '8',
    'b' -> '6',
    's' -> '5',
    'z' -> '2',

    'E' -> '3',
    'Z' -> '2',
    'I' -> '1',
    'O' -> '0',
    'D' -> '0',
    'B' -> '8',
    'S' -> '5',
    'A' -> '4'
  )

  val toCharRules = List(
    '|' -> 'I',
    '!' -> 'I',

    'l' -> 'I',

    '0' -> 'O',
    '1' -> 'I',
    '3' -> 'E',
    '4' -> 'A',
    '5' -> 'S',
    '6' -> 'B',
    '7' -> 'L',
    '8' -> 'B',
    '9' -> 'G'
  )

  private val ruleMap = Map(
    'C' -> toCharRules,
    'D' -> toDigitRules
  )

  // TODO: This pattern is NL only
  private val simplePattern = "CCDDCCCCDDDDDDDDDD"


  private def simplify(char: Char) = char match {
      case c if c.isDigit => 'D'
      case c if c.isUpper => 'C'
      case _ => '_'
  }

  private def wrongIndices(wrongIban: String) = {
    wrongIban
      .map(simplify)
      .zip(simplePattern)
      .zipWithIndex
      .collect {
        case ((char1, char2), i) if char1 != char2 => i
      }
  }

  def corrections(wrongIban: String): Seq[String] = {
    val indices = wrongIndices(wrongIban)

    val options = indices
      .map(wrongIban.charAt)
      .zip(indices.map(simplePattern.charAt))
      .map {
        case (inputChar, patternChar) =>
          ruleMap.getOrElse(patternChar, List()).collect {
            case (`inputChar`, replaceChar) => replaceChar
          }
      }

    CorrectionUtils.permutations(options).map(
      CorrectionUtils.replaceCharsAt(wrongIban, indices, _)
    )
  }

}

object IbanCorrectionFunctions {
  implicit def correctIban(iban: String) = new IbanCorrector(iban)
}
