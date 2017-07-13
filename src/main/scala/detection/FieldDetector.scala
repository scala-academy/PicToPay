package detection

import java.io.File
import java.net.URL

import com.sksamuel.scrimage.Image
import com.sksamuel.scrimage.nio.PngWriter
import domain.{Field, FieldCoordinates}


object FieldDetector {

  val fieldsCoordinates = List(
    FieldCoordinates("IBAN", 190, 213, 121, 15))
    //FieldCoordinates("AmountOwed", 190, 59, 20, 15))

  //override default writer compression config to gain max image quality
  implicit val writer = PngWriter.NoCompression

  // Takes an image file and generates image files of different fields
  def map(img: URL): List[Field] = {
    val path = img.getPath
    val image = Image.fromFile(new File(path))

    fieldsCoordinates.map(c => {
      val l = c.label
      val outputUrl = path.replace(path.substring(path.lastIndexOf("/")), "/generated" + l + ".png")
      val createImage = image.subimage(c.x, c.y, c.w, c.h).output(new File(outputUrl))
      Field(l, outputUrl)
    })
  }


}
