package ocr

import domain._
import org.bytedeco.javacpp.lept.{pixDestroy, pixRead}
import org.bytedeco.javacpp.tesseract

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object OcrProcessor {
  val TESSDATA_PREFIX = "data/tesseract-ocr-3.02/"
  val lang = "eng"
  val t = tesseract.TessBaseAPICreate
  val rc = tesseract.TessBaseAPIInit3(t, TESSDATA_PREFIX, lang)

  if (rc != 0) {
    tesseract.TessBaseAPIDelete(t)
    println("Init failed")
    sys.exit(3)
  }

  // TODO: Future?
  def map(f: Field): RecognizedValue = {

    val image = pixRead(f.picture)
    t.SetImage(image)
    val result = RecognizedValue(Value(f.label, t.GetUTF8Text.getString))
    t.End
    result
  }
}


object OcrProcessorApp extends App {

  val path = "data/eurotext.png"

  val f = Field("test", path)

  import OcrProcessor._

  val rValue = map(f)

  println(rValue)



}

