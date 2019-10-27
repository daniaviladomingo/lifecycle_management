package avila.domingo.lifecycle

import android.app.Application
import avila.domingo.lifecycle.di.activityModule
import avila.domingo.lifecycle.di.lifecycleObserverModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            androidLogger()
            modules(
                activityModule,
                lifecycleObserverModule
            )
        }
    }
}