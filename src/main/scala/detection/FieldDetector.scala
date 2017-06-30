package detection

import java.io.File
import java.net.URL

import com.sksamuel.scrimage.Image
import com.sksamuel.scrimage.nio.PngWriter
import domain.Field


object FieldDetector {

  val fieldCoordinates = List(("IBAN", 190, 213, 121, 15), ("AmountOwed", 190, 59, 20, 15))

  // Takes an image file and generates image files of different fields
  def map(img: URL): List[Field] = {

    //override default writer compression config to gain max image quality
    implicit val writer = PngWriter.NoCompression
    val path = img.getPath
    val image = Image.fromFile(new File(path))

    fieldCoordinates.map(f => {
      val label = f._1
      val fieldImage = path.replace(path.substring(path.lastIndexOf("/")), "/generated" + label + ".png")
      image.subimage(f._2, f._3, f._4, f._5).output(new File(fieldImage))
      Field(label, fieldImage)
    })
  }
}
