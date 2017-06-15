package main.scala

import orchestration.Orchestrator

class OrchestratorSpec extends BaseSpec {

  "The Orchestrator" should "product some output" in {
    val output = Orchestrator.run("test")
    output should not(be(None))
  }
}
