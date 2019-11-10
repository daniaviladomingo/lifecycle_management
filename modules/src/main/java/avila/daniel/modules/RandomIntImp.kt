package avila.daniel.modules

import avila.domingo.domain.IRandom
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class RandomIntImp(
    private val period: Long,
    private val timeUnit: TimeUnit,
    private val source: IntRange
): IRandom<Int> {
    override fun generate(): Observable<Int> = Observable.interval(period, timeUnit).map {
        source.random()
    }
}