import orchestration.Orchestrator

object Main extends App {
  println("Pic2Pay!")

  println(Orchestrator.run("input"))

  println("Done.")
}
