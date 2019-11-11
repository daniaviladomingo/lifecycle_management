package avila.domingo.lifecycle.ui

import avila.domingo.cameramanager.schedulers.IScheduleProvider
import avila.domingo.domain.interactor.GenerateRandomDoubleUseCase
import avila.domingo.domain.interactor.GenerateRandomIntUseCase
import avila.domingo.lifecycle.base.BaseViewModel
import avila.domingo.lifecycle.ui.data.Resource
import avila.domingo.lifecycle.util.SingleLiveEvent

class MainActivity1ViewModel(
    private val generateRandomDoubleUseCase: GenerateRandomDoubleUseCase,
    private val generateRandomIntUseCase: GenerateRandomIntUseCase,
    private val scheduleProvider: IScheduleProvider
) : BaseViewModel() {

    val randomDoubleLiveData = SingleLiveEvent<Resource<Double>>()
    val randomIntLiveData = SingleLiveEvent<Resource<Int>>()

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

    fun generateRandomInt() {
        addDisposable(generateRandomIntUseCase.execute()
            .observeOn(scheduleProvider.ui())
            .subscribeOn(scheduleProvider.computation())
            .subscribe({ int ->
                randomIntLiveData.value = Resource.success(int)
            }) {
                randomIntLiveData.value = Resource.error(it.localizedMessage)
            })
    }
}