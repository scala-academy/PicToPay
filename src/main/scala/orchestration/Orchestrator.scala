/**
  * ING - CONFIDENTIAL
  * ---------------------------------
  * Copyright (C) 2017 ING Groep N.V.
  * All rights reserved.
  * ---------------------------------
  */
package orchestration

import detection.FieldDetector
import ocr.OcrProcessor

object Orchestrator {
  def run = {
    val input = "random"

    val fields = FieldDetector.map(input)

    for (field <- fields) {
      val ocr = OcrProcessor.map(field)
    }
  }
}
