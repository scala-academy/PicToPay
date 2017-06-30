package orchestration

import java.net.URL

import collection.Collector
import correction.Corrector
import detection.FieldDetector
import ocr.OcrProcessor
import output.OutputGenerator
import validation.Validator


object Orchestrator {
  def run(imgFile: URL): String = {
    println(imgFile.getPath)

    val fields = FieldDetector.map(imgFile)
    val processed = for {field <- fields} yield OcrProcessor.map(field)
    val collected = Collector.map(processed)
    val corrected = Corrector.map(collected)
    val validated = Validator.map(corrected)
    val output = OutputGenerator.map(validated)

    output
  }
}
