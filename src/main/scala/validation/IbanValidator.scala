package validation

/**
  * Created by GK46IV on 15-6-2017.
  */
object IbanValidator {
  def validate(iban: String): Status = {
    if (checkSumCheck(iban)) Valid
//    else if (correctIban(iban)) Corrected
    else Invalid
  }

  def checkSumCheck(iban: String): Boolean = {
    val ibanPrefix = iban.take(4)
    val shuffledIban = iban.drop(4) + ibanPrefix
    val encodedIban = shuffledIban.map(ch => if (ch.isDigit) ch.toInt - '0'.toInt else ch - 'A'.toInt + 10).mkString
    (BigInt(encodedIban) mod 97) == 1
  }
}
