package validation

/**
  * Created by GK46IV on 15-6-2017.
  */
sealed trait Status
case object Absent extends Status
case object Valid extends Status
case object Corrected extends Status
case object Invalid extends Status
