package detection


import java.io.File

import com.sksamuel.scrimage.nio.PngWriter
import com.sksamuel.scrimage.Image


object ImageCropper {

  /**
    * Takes an accept giro image URL and persists to file system,
    * a subsection .png of the image showing just the IBAN number
    */

  def crop(imgUrl:String) {


    val image = Image.fromFile(new File(imgUrl)).subimage(190,213,121,15)

    /**
      * TODO: pros and cons of making it image file type agnostic. Should it this feature be defined here or somehow inherited
      * from the moment when the file is added.
      */

    implicit val writer = PngWriter.NoCompression

    // use custom implicit writer defined above instead of default
    image.output (new File("src/resources/croppedAcceptGiro.png"))
    println("Successfully cropped IBAN field")

  }

}
