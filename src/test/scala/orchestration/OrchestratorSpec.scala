package orchestration

import testUtils.BaseSpec

class OrchestratorSpec extends BaseSpec {

  "Orchestrator" should "throw an exception when no file given" in {
    val thrown = intercept[Exception] {
      val imgFile = getClass.getResource("/does-not-exist.png")
      val output = Orchestrator.run(imgFile)
      output should contain("NoSuchFileException")
    }
  }
}
