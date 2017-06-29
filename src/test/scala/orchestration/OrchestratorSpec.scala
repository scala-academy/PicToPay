package orchestration

import testUtils.BaseSpec

class OrchestratorSpec extends BaseSpec {

  "Orchestrator" should "throw an exception when no file given" in {
    //val thrown = intercept[Exception] {
      val output = Orchestrator.run("")
      output should contain("NoSuchFileException")
    //}
  }
}
