package avila.domingo.lifecycle

import android.app.Application
import avila.domingo.lifecycle.di.*
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
                modulesModule,
                useCaseModule,
                scheduleModule,
                viewModelModule
            )
        }
    }
}