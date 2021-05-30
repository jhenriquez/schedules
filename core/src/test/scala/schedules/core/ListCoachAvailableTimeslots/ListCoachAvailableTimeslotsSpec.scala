package schedules.core.ListCoachAvailableTimeslots

package schedules.core.ListAvailableCoaches

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.matchers.should.Matchers
// import schedules.core.tests.utilities.Data

// TODO: Complete this test

class ListAvailableCoachesSpec extends AnyFeatureSpec with GivenWhenThen with Matchers {
    info ("As a user");
    info ("I want to see what 30 minute timeslots are available to schedule with a particular coach.");
    
    Feature ("List coach available timeslots") {
        Scenario ("User requests to see a list of available coaches without appointments") {
            Given ("The following configured schedules")
            // val availableData = Data.getAvailableData()

            // forAll(availableData)((coach, timezone, weekday, availableAt, availableUntil) => {
            //     info (s"| $coach | $timezone | $weekday | $availableAt | $availableUntil |")
            // });

            When ("A user requests to see a list of available timeslots for a coach")

            Then ("A list of the following coaches should be produced")
            info ("| coach |")
        }
    }
}