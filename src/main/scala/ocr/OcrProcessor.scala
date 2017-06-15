package ocr

import domain.{Field, RecognizedValue, Value}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object OcrProcessor {
  def map(f: Field): Future[RecognizedValue] = Future(RecognizedValue(Value("IBAN", "test")))
}
