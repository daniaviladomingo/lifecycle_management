package avila.daniel.modules

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class RandomStringImp(
    private val period: Long,
    private val timeUnit: TimeUnit,
    private val source: String,
    private val lenght: Int
) : BaseRandom<String>() {
    override fun createObservable(): Observable<String> = Observable.interval(period, timeUnit).map {
        (1..lenght).map { source.random() }.joinToString("")
    }
}