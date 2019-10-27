package avila.domingo.lifecycle.di

import androidx.lifecycle.Lifecycle
import avila.domingo.lifecycle.di.qualifiers.Ac1
import avila.domingo.lifecycle.di.qualifiers.Ac2
import avila.domingo.lifecycle.di.qualifiers.M1
import avila.domingo.lifecycle.di.qualifiers.M2
import avila.domingo.lifecycle.lifecycle.ILifecycleObserver
import avila.domingo.lifecycle.lifecycle.LifecycleManager
import avila.domingo.lifecycle.modules.Module1LifecycleSubscriber
import avila.domingo.lifecycle.modules.Module2LifecycleSubscriber
import org.koin.dsl.bind
import org.koin.dsl.module

val activityModule = module {
    factory(Ac1) { (lifecycle: Lifecycle) ->
        LifecycleManager(arrayOf(get(M1)), lifecycle)
        Unit
    }

    factory(Ac2) { (lifecycle: Lifecycle) ->
        LifecycleManager(arrayOf(get(M1)), lifecycle)
        Unit
    }
}

val lifecycleObserverModule = module {
    single(M1) {
        Module1LifecycleSubscriber()
    } bind ILifecycleObserver::class

    single(M2) {
        Module2LifecycleSubscriber()
    } bind ILifecycleObserver::class
}