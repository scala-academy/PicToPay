package correction

import testUtils.BaseSpec

class CorrectionUtilSpec extends BaseSpec {

  behavior of "permutations function"
  it should "compute permutations correctly" in {
    val input = List(List(1,2), List(3,4,5))
    val output = CorrectionUtils.permutations(input)

    val permutations = List(
      List(1, 3), List(1, 4), List(1, 5),
      List(2, 3), List(2, 4), List(2, 5)
    )

    output should contain allElementsOf permutations
  }

  it should "compute multiple permutations correctly" in {
    val input = List(List(1,2), List(3,4), List(5,6))
    val output = CorrectionUtils.permutations(input)

    val permutations = List(
      List(1, 3, 5), List(1, 3, 6),
      List(1, 4, 5), List(1, 4, 6),
      List(2, 3, 5), List(2, 3, 6),
      List(2, 4, 5), List(2, 4, 6)
    )

    output should contain allElementsOf permutations
  }

  it should "deal with single options correctly" in {
    val input = List(List(1), List(2), List(3, 4, 5))
    val output = CorrectionUtils.permutations(input)
    val permutations = List(List(1, 2, 3), List(1, 2, 4), List(1, 2, 5))
    output should contain allElementsOf permutations
  }


  behavior of "replaceChars"

  it should "replace a single char in a string" in {
    val replaced = CorrectionUtils.replaceCharsAt("012345", List(3), List('c'))
    replaced shouldBe "012c45"
  }

  it should "replace a multiple chars in a string" in {
    val replaced = CorrectionUtils.replaceCharsAt("012345", List(1, 3, 5), List('c', 'c', 'd'))
    replaced shouldBe "0c2c4d"
  }

}
