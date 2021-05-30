package schedules.core.common.repositories

trait Repository[T] {
    def Find(): Iterator[T]
}