package detection

import testUtils.BaseSpec

class FieldDetectorSpec extends BaseSpec {

  "The FieldDetector" should "yeild at least an IBAN" in {
    val imgFile = "src/test/resources/testPics/Acceptgiro_ok-scale1-1.png"
    val output = FieldDetector.map(imgFile)
    output.contains("src/resources/generatedIBAN.png")
  }
}
