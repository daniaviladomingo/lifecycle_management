package avila.daniel.modules

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class RandomIntImp(
    private val period: Long,
    private val timeUnit: TimeUnit,
    private val source: IntRange
) : BaseRandom<Int>() {
    override fun createObservable(): Observable<Int> =
        Observable.interval(period, timeUnit).map { source.random() }
}