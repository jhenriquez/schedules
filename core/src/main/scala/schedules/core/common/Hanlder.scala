package schedules.core.common

trait Handler[TMessage, TResult] {
    def execute(message: TMessage): TResult
}