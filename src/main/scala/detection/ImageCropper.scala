package detection

/**
  * Takes an accept giro image URL and persists to file system, a subsection of the image showing just the IBAN number
  */
import java.io.File

import com.sksamuel.scrimage.nio.PngWriter
import com.sksamuel.scrimage.{Color, Image}
import domain.Field
import scala.io.Source


object ImageCropper {

  def crop(imgUrl:String) {

    implicit val writer = PngWriter.NoCompression
    //val bufferedSourceOut = Source.fromFile("/Users/AirSe/Documents/Study/PicToPay/src/resources/croppedAcceptGiro.png")
    var image = Image.fromFile(new File(imgUrl)).autocrop(Color.White)
    // val image = Image.fromFile(new File("/Users/AirSe/Documents/Study/PicToPay/src/resources/Acceptgiro_ok-scale1-1.png")).autocrop(Color.White)

    image.output(new File("/Users/AirSe/Documents/Study/PicToPay/src/resources/croppedAcceptGiro.png")) // use custom implicit writer instead of default

    //bufferedSourceIn.close
  }

}
