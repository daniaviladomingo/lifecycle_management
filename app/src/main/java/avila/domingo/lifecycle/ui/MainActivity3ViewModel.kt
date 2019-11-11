package avila.domingo.lifecycle.ui

import avila.domingo.cameramanager.schedulers.IScheduleProvider
import avila.domingo.domain.interactor.GenerateRandomDoubleUseCase
import avila.domingo.domain.interactor.GenerateRandomIntUseCase
import avila.domingo.domain.interactor.GenerateRandomStringUseCase
import avila.domingo.lifecycle.base.BaseViewModel
import avila.domingo.lifecycle.ui.data.Resource
import avila.domingo.lifecycle.util.SingleLiveEvent

class MainActivity3ViewModel(
    private val generateRandomStringUseCase: GenerateRandomStringUseCase,
    private val generateRandomDoubleUseCase: GenerateRandomDoubleUseCase,
    private val scheduleProvider: IScheduleProvider
) : BaseViewModel() {

    val randomStringLiveData = SingleLiveEvent<Resource<String>>()
    val randomDoubleLiveData = SingleLiveEvent<Resource<Double>>()

    fun generateRandomString() {
        addDisposable(generateRandomStringUseCase.execute()
            .observeOn(scheduleProvider.ui())
            .subscribeOn(scheduleProvider.computation())
            .subscribe({ string ->
                randomStringLiveData.value = Resource.success(string)
            }) {
                randomStringLiveData.value = Resource.error(it.localizedMessage)
            })
    }

    fun generateRandomDouble() {
        addDisposable(generateRandomDoubleUseCase.execute()
            .observeOn(scheduleProvider.ui())
            .subscribeOn(scheduleProvider.computation())
            .subscribe({ double ->
                randomDoubleLiveData.value = Resource.success(double)
            }) {
                randomDoubleLiveData.value = Resource.error(it.localizedMessage)
            })
    }
}