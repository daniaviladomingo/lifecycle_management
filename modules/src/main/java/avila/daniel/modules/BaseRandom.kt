package avila.daniel.modules

import avila.domingo.domain.IRandom
import io.reactivex.Observable

import java.util.concurrent.atomic.AtomicBoolean

abstract class BaseRandom<T> : IRandom<T>, ILifecycleObserver {
    private var observable: Observable<T>? = null
    private val resumed = AtomicBoolean(true)

    override fun generate(): Observable<T> =
        observable ?: createObservable().filter { resumed.get() }.apply { observable = this }

    override fun resume() {
        resumed.set(true)
    }

    override fun pause() {
        resumed.set(false)
    }

    abstract fun createObservable(): Observable<T>
}