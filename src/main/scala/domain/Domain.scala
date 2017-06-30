package domain

case class Value(label: String, value: String)

case class ValidatedValue(label: String, value: String, status: String)

// FieldDetector --> OCR
case class Field(label: String, picture: String)

// OCR --> Collector
case class RecognizedValue(value: Value)

// Collector --> correction
case class CollectedValues(list: List[Value])

// correction --> Validator
case class CorrectedValues(list: List[Value])

// Validator --> OutputGenerator
case class ValidatedValues(list: List[ValidatedValue])
