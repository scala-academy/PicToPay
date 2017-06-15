package ocr

import domain.{Field, RecognizedValue, Value}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object OcrProcessor {
  // TODO: Future?
  def map(f: Field): RecognizedValue = RecognizedValue(Value("IBAN", "test"))
}
