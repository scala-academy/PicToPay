package ocr

import domain._
import org.bytedeco.javacpp.lept.{pixDestroy, pixRead}
import org.bytedeco.javacpp.tesseract

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object OcrProcessor {

  def init(): tesseract.TessBaseAPI  = {
    val TESSDATA_PREFIX = "data/tesseract-ocr-3.02/"
    val lang = "eng"
    val t: tesseract.TessBaseAPI = tesseract.TessBaseAPICreate
    val rc = tesseract.TessBaseAPIInit3(t, TESSDATA_PREFIX, lang)

    if (rc != 0) {
      tesseract.TessBaseAPIDelete(t)
      println("Init failed")
      sys.exit(3)
    }  else {
      println("Init is okay")
    }

    t
  }

  // TODO: Future?
  def map(f: Field): RecognizedValue = {
    val t = init()
    val image = pixRead(f.picture)
    t.SetImage(image)
    val result = RecognizedValue(Value(f.label, t.GetUTF8Text.getString))
    t.End
    result
  }
}


object OcrProcessorApp extends App {

  import  OcrProcessor._

  val result = map(Field("test", "data/test1.png"))

  println(result.value.value.trim)
}

