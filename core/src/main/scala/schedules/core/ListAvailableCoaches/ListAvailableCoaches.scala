package schedules.core.ListAvailableCoaches

import schedules.core.common.Message
import scala.collection.immutable
import schedules.core.common.Handler

final case class ListAvailableCoaches()
    extends Message[Either[String, Seq[String]]]

object ListAvailableCoachesHandler extends Handler[ListAvailableCoaches, Either[String, Seq[String]]] {
    override def execute(message: ListAvailableCoaches): Either[String, Seq[String]] = Right(List())
}