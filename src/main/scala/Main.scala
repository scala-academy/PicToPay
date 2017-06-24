import detection.ImageCropper
import orchestration.Orchestrator

object PicToPay {

  def main(args: Array[String]): Unit = {
    println("Pic2Pay!")

    val imgFile = args.mkString

    //TODO: add validation for the args.mkString?
    println(Orchestrator.run(imgFile))

    println("Done.")
  }

}
