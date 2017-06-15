package orchestration

import collection.Collector
import correction.Corrector
import detection.FieldDetector
import ocr.OcrProcessor
import output.OutputGenerator
import validation.Validator

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Orchestrator {
  def run(input: String): String = {
    val fields = FieldDetector.map(input)

    val processed = for {field <- fields} yield OcrProcessor.map(field)
    val collected = Collector.map(processed)
    val corrected = Corrector.map(collected)
    val validated = Validator.map(corrected)
    val output = OutputGenerator.map(validated)

    output
  }
}
