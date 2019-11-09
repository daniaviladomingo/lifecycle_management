package avila.domingo.domain.interactor.type

import io.reactivex.Observable

interface ObservableUseCase<P> {
    fun execute(): Observable<P>
}