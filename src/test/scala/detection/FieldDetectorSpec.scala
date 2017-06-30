package detection

import testUtils.BaseSpec

class FieldDetectorSpec extends BaseSpec {

  "The FieldDetector" should "yeild an IBAN" in {
    val imgFile = getClass.getResource("/testPics/Acceptgiro_ok-scale1-1.png")
    val output = FieldDetector.map(imgFile)
    val result = output.map(f => f.label)
    result should contain("IBAN")
  }
}