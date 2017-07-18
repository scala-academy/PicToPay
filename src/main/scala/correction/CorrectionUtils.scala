package correction

import scala.collection.mutable.ListBuffer

object CorrectionUtils {

  def replaceCharsAt(string: String, indices: Seq[Int], replacements: Seq[Char]): String = {
    replacements
      .zip(indices)
      .foldLeft(string) {
        case (s, (c, i)) => s.updated(i, c)
      }
  }

  def permutations[T](optionsList: Seq[Seq[T]]): Seq[Seq[T]] = {
    var permutations = List(List[T]())

    for (options <- optionsList) {
      // Variable to build up intermediate results
      val temp = new ListBuffer[List[T]]()
      for {
        option <- options
        permutation <- permutations
      } {
          temp += permutation ++ List(option)
      }
      permutations = temp.toList
    }
    permutations
  }
}
