package schedules.core.utilities
import scala.io.Source
import org.scalatest.prop.TableDrivenPropertyChecks._

object Data {
    def getAvailableData() = {
        val dataStream = getClass().getResourceAsStream("/data.csv")

        val rows = Source.fromInputStream(dataStream).getLines.map((row) => 
            row.split(",") match {
                case Array(name, timezone, weekday, availableAt, availableUntil) => (name, timezone, weekday, availableAt, availableUntil)
            }).toList

        Table(
            heading = rows.head,
            rows = rows.slice(1, rows.length): _*
        )
    }
}