package avila.daniel.modules

import avila.domingo.domain.IRandom
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class RandomDoubleImp(
    private val period: Long,
    private val timeUnit: TimeUnit,
    private val random: Random
): IRandom<Double> {
    override fun generate(): Observable<Double> = Observable.interval(period, timeUnit).map {
        random.nextDouble()
    }
}