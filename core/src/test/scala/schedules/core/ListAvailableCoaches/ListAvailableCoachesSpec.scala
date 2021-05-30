package schedules.core.ListAvailableCoaches

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.matchers.should.Matchers
import schedules.core.common.repositories.CSVSampleDataRepository
import schedules.core.tests.utilities.Data

class ListAvailableCoachesSpec extends AnyFeatureSpec with GivenWhenThen with Matchers {
    info ("As a user");
    info ("I want to see which coaches I can schedule with");
    
    Feature ("List available coaches") {
        Scenario ("User requests to see a list of avaible coaches") {
            Given ("The following configured schedules")
            val availableData = Data.getAvailableData()
            val availableNames = availableData.groupBy(coach => coach._1).map { case (coach, _) => coach }

            forAll(availableData)((coach, timezone, weekday, availableAt, availableUntil) => {
                info (s"| $coach | $timezone | $weekday | $availableAt | $availableUntil |")
            });

            When ("A user requests to see a list of avaible coaches")
            val listAvailableCoaches = ListAvailableCoaches()

            // TODO: Construct the handler using some kind of DI container or technique.
            val coaches = new ListAvailableCoachesHandler(new CSVSampleDataRepository).execute(listAvailableCoaches)

            Then ("A list of the following coaches should be produced")
            info ("| coach |")
            availableNames.foreach((coach) => info (s"| $coach |"))

            coaches.map(_.name) should equal (availableNames)
        }
    }
}