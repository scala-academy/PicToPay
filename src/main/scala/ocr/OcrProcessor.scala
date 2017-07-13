package ocr

import domain._
import org.bytedeco.javacpp.lept.{pixDestroy, pixRead}
import org.bytedeco.javacpp.tesseract

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object OcrProcessor {
  val TESSDATA_PREFIX = "data/tesseract-ocr-3.02/"
  val lang = "eng"

  def init(): tesseract.TessBaseAPI  = {
    val t: tesseract.TessBaseAPI = tesseract.TessBaseAPICreate
    val rc = tesseract.TessBaseAPIInit3(t, TESSDATA_PREFIX, lang)

    if (rc != 0) {
      tesseract.TessBaseAPIDelete(t)
      //TODO: add logger
      println("Failed to initalize Tesseract")
      sys.exit(3)
    }
    t
  }

  def map(f: Field): RecognizedValue = {
    val t = init()
    val image = pixRead(f.picture)
    t.SetImage(image)
    val result = RecognizedValue(Value(f.label, t.GetUTF8Text.getString))
    t.End
    result
  }
}
