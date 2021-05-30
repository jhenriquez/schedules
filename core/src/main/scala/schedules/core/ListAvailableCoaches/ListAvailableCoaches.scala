package schedules.core.ListAvailableCoaches

import schedules.core.common.Message
import scala.collection.immutable
import schedules.core.common.Handler
import schedules.core.common.repositories.CSVSampleDataRepository
import schedules.core.common.repositories.Repository
import schedules.core.common.values._

final case class ListAvailableCoaches()
    extends Message[Seq[Coach]]

    // TODO: Error Handling????
class ListAvailableCoachesHandler(coachRepository: Repository[CoachScheduleEntry]) extends Handler[ListAvailableCoaches, Seq[Coach]] {
    override def execute(message: ListAvailableCoaches): Seq[Coach] =
        coachRepository.Find().toTraversable.view.groupBy(_.name).map((group) => Coach(group._1)).toSeq
}