package avila.daniel.modules

import avila.domingo.domain.IRandom
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class RandomStringImp(
    private val period: Long,
    private val timeUnit: TimeUnit,
    private val source: String,
    private val lenght: Long
): IRandom<String> {
    override fun generate(): Observable<String> = Observable.interval(period, timeUnit).map {
        (1..lenght).map { source.random() }.joinToString("")
    }
}