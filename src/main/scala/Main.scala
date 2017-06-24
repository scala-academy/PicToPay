import orchestration.Orchestrator

object PicToPay {

  def main(args: Array[String]): Unit = {
    println("Pic2Pay!")

    val imgFile = args.mkString

    println(Orchestrator.run(imgFile))

    println("Done.")
  }

}
