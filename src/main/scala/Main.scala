import orchestration.Orchestrator

object PicToPay extends App{
  println("Pic2Pay!")

  val imgFile = getClass.getResource("Acceptgiro_ok-scale1-1.png")
  println(imgFile.getPath)


  println(Orchestrator.run(imgFile))

  println("Done.")

}
