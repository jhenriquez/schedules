package schedules.core.ListAvailableCoaches

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.matchers.should.Matchers

class ListAvailableCoachesSpec extends AnyFeatureSpec with GivenWhenThen with Matchers {
    info ("As a user");
    info ("I want to see which coaches I can schedule with");
    
    Feature ("List available coaches") {
        Scenario ("User requests to see a list of avaible coaches") {
            Given ("The following configured schedules")
            val availableData = schedules.core.utilities.Data.getAvailableData()
            val availableNames = availableData.groupBy(coach => coach._1).map { case (coach, _) => coach }

            forAll(availableData)((coach, timezone, weekday, availableAt, availableUntil) => {
                info (s"| $coach | $timezone | $weekday | $availableAt | $availableUntil |")
            });

            When ("A user requests to see a list of avaible coaches")
            val listAvailableCoaches = ListAvailableCoaches()
            val result = ListAvailableCoachesHandler.execute(listAvailableCoaches)

            Then ("A list of the following coaches should be produced")
            info ("| coach |")
            availableNames.foreach((coach) => info (s"| $coach |"))

            result match {
                case Left(value) => fail()
                case Right(names) => names should contain (availableNames)
            }
        }
    }
}