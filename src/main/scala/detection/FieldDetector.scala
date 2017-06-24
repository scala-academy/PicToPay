package detection

import java.io.File

import com.sksamuel.scrimage.Image
import com.sksamuel.scrimage.nio.PngWriter
import domain.{Field, FieldCoordinates}


object FieldDetector {

  val fieldCoordinates = List(
    FieldCoordinates("IBAN", 190, 213, 121, 15),
    FieldCoordinates("AmountOwed", 190, 59, 20, 15))

  def map(imgUrl: String): List[Field] = {

    //override default writer compression config to gain max image quality
    implicit val writer = PngWriter.NoCompression
    val image = Image.fromFile(new File(imgUrl))

    def crop(c: FieldCoordinates): Field = {
      val l = c.label
      val outputUrl = "src/resources/generated" + l + ".png"
      image.subimage(c.x, c.y, c.w, c.h).output(new File(outputUrl))
      Field(l, outputUrl)
    }

    fieldCoordinates.map(FieldCoordinates =>  crop(FieldCoordinates))
  }
}
