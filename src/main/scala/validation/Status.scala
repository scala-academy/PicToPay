package validation

sealed trait Status

case object Absent extends Status

case object Valid extends Status

case object Corrected extends Status

case object Invalid extends Status
