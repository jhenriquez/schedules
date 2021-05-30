package schedules.core.common.values

// TODO: ???
// type WeekDay = "Monday" | "Tuesday" | "Wednesday" | "Thursday" | "Friday" | "Saturday" | " Sunday"

case class CoachScheduleEntry (name: String, timezone: String, weekday: String, availableAt: String, availableUntil: String)