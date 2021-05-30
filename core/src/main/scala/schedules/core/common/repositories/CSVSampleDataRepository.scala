package schedules.core.common.repositories

import scala.io.Source
import schedules.core.common.values.CoachScheduleEntry

class CSVSampleDataRepository extends Repository[CoachScheduleEntry] {
  override def Find(): Iterator[CoachScheduleEntry] = {
    val dataStream = getClass().getResourceAsStream("/data.csv")

    Source.fromInputStream(dataStream).getLines.drop(1).map((row) => 

        row.split(",") match {
            case Array(name, timezone, weekday, availableAt, availableUntil) =>
                CoachScheduleEntry(name, timezone, weekday, availableAt, availableUntil)
        })
  }
}