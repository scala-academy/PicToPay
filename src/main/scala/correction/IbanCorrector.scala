package correction

class IbanCorrector(val iban: String) {
  def correctIban: String = {
    println("correcting " + iban)
    correctIbanWhiteSpace
      .map(c => charsToNumbers(c))

    // apply numbers -> chars rules

    // use checksum.
    // what happens if no valid IBAN can be found??
  }

  def correctIbanWhiteSpace: String = {
    iban.trim().replaceAll(" ", "")
  }

  val charsToNumbers = Map(
    'e' -> '3',
    'i' -> '1',
    'o' -> '0',
    'l' -> '1',
    'b' -> '8',
    's' -> '5',

    'E' -> '3',
    'I' -> '1',
    'O' -> '0',
    'B' -> '8',
    'S' -> '5',
    'A' -> '4'
  ).withDefault(c => c)

  val numbersToChars = Map(
    '0' -> 'O',
    '1' -> 'I',
    '3' -> 'E',
    '4' -> 'A',
    '5' -> 'S',
    '6' -> 'B',
    '7' -> 'L',
    '8' -> 'B',
    '9' -> 'G'
  ).withDefault(c => c)
}

object IbanCorrectionFunctions {
  implicit def correctIban(iban: String) = new IbanCorrector(iban)
}
