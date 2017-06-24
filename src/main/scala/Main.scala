import detection.ImageCropper
import orchestration.Orchestrator

object Main extends App {
  println("Pic2Pay!")

  println(Orchestrator.run("input"))
  ImageCropper.crop("/Users/AirSe/Documents/Study/PicToPay/src/resources/Acceptgiro_ok-scale1-1.png")

  println("Done.")
}
