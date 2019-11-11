package avila.domingo.lifecycle.di

import androidx.lifecycle.Lifecycle
import avila.daniel.modules.RandomDoubleImp
import avila.daniel.modules.RandomIntImp
import avila.daniel.modules.RandomStringImp
import avila.domingo.cameramanager.schedulers.IScheduleProvider
import avila.domingo.cameramanager.schedulers.ScheduleProviderImp
import avila.domingo.domain.interactor.GenerateRandomDoubleUseCase
import avila.domingo.domain.interactor.GenerateRandomIntUseCase
import avila.domingo.domain.interactor.GenerateRandomStringUseCase
import avila.domingo.lifecycle.LifecycleManager
import avila.domingo.lifecycle.di.qualifiers.*
import avila.domingo.lifecycle.ui.MainActivity1ViewModel
import avila.domingo.lifecycle.ui.MainActivity2ViewModel
import avila.domingo.lifecycle.ui.MainActivity3ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

val activityModule = module {
    factory(Ac1) { (lifecycle: Lifecycle) ->
        LifecycleManager(arrayOf(get(DoubleM), get(IntM)), lifecycle)
        Unit
    }

    factory(Ac2) { (lifecycle: Lifecycle) ->
        LifecycleManager(arrayOf(get(IntM), get(StringM)), lifecycle)
        Unit
    }

    factory(Ac3) { (lifecycle: Lifecycle) ->
        LifecycleManager(arrayOf(get(StringM), get(DoubleM)), lifecycle)
        Unit
    }
}

val modulesModule = module {
    single(DoubleM) {
        RandomDoubleImp(get(), get())
    }

    single(IntM) {
        RandomIntImp(get(), get(), get())
    }

    single(StringM) {
        RandomStringImp(get(), get(), get(), get())
    }

    single { 1000L }
    single { TimeUnit.MILLISECONDS }
    single { 0..Int.MAX_VALUE }
    single { "0123456789ABCDEF"}
    single { 8 }
}

val useCaseModule = module {
    single { GenerateRandomStringUseCase(get(StringM)) }
    single { GenerateRandomIntUseCase(get(IntM)) }
    single { GenerateRandomDoubleUseCase(get(DoubleM)) }
}

val scheduleModule = module {
    single<IScheduleProvider> { ScheduleProviderImp() }
}

val viewModelModule = module {
    viewModel {
        MainActivity1ViewModel(get(), get(), get())
    }

    viewModel {
        MainActivity2ViewModel(get(), get(), get())
    }

    viewModel {
        MainActivity3ViewModel(get(), get(), get())
    }
}