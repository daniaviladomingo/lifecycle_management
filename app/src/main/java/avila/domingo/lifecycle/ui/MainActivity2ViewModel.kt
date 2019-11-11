package avila.domingo.lifecycle.ui

import avila.domingo.cameramanager.schedulers.IScheduleProvider
import avila.domingo.domain.interactor.GenerateRandomIntUseCase
import avila.domingo.domain.interactor.GenerateRandomStringUseCase
import avila.domingo.lifecycle.base.BaseViewModel
import avila.domingo.lifecycle.ui.data.Resource
import avila.domingo.lifecycle.util.SingleLiveEvent

class MainActivity2ViewModel(
    private val generateRandomIntUseCase: GenerateRandomIntUseCase,
    private val generateRandomStringUseCase: GenerateRandomStringUseCase,
    private val scheduleProvider: IScheduleProvider
) : BaseViewModel() {

    val randomIntLiveData = SingleLiveEvent<Resource<Int>>()
    val randomStringLiveData = SingleLiveEvent<Resource<String>>()

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
}