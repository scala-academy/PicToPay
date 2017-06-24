package domain

case class Value(label: String, value: String)

case class ValidatedValue(label: String, value: String, status: String)

// FieldDetector --> OCR

/**
  * @param x the start x coordinate
  * @param y the start y coordinate
  * @param w the width of the fieldImage
  * @param h the height of the fieldImage
  */

case class FieldCoordinates(label: String, x: Int, y: Int, w: Int, h: Int)

case class Field(label: String, picture: String)

// OCR --> Collector
case class RecognizedValue(value: Value)

// Collector --> correction
case class CollectedValues(list: List[Value])

// correction --> Validator
case class CorrectedValues(list: List[Value])

// Validator --> OutputGenerator
case class ValidatedValues(list: List[ValidatedValue])
