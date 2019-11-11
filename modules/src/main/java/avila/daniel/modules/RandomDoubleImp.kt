package avila.daniel.modules

import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class RandomDoubleImp(
    private val period: Long,
    private val timeUnit: TimeUnit
) : BaseRandom<Double>() {
    override fun createObservable(): Observable<Double> =
        Observable.interval(period, timeUnit).map { Random.nextDouble() }
}