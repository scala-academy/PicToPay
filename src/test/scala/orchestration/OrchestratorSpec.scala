package orchestration

import testUtils.BaseSpec

class OrchestratorSpec extends BaseSpec {

  " Orchestrator" should "throw an exception" in {
    val thrown = intercept[Exception] {
      val output = Orchestrator.run("test")
      output should contain("NoSuchFileException")
    }
  }



}
