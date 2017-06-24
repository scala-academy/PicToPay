import detection.ImageCropper
import orchestration.Orchestrator

object PicToPay {

  def main(args: Array[String]): Unit = {
    println("Pic2Pay!")

    val imgUrl = args.mkString
    println(Orchestrator.run(imgUrl))


    println("Done.")
  }

}
