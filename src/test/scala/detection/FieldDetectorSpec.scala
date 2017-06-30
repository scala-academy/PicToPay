package detection

import testUtils.BaseSpec

class FieldDetectorSpec extends BaseSpec {

  "The FieldDetector" should "yeild at least an IBAN" in {
    val imgFile = getClass.getResource("/does-not-exist.png")
    val output = FieldDetector.map(imgFile)
    output.contains("src/resources/generatedIBAN.png")
  }
}
