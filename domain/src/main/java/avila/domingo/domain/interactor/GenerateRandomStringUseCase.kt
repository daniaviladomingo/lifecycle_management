package avila.domingo.domain.interactor

import avila.domingo.domain.IRandom
import avila.domingo.domain.interactor.type.ObservableUseCase
import io.reactivex.Observable

class GenerateRandomStringUseCase(private val randomString: IRandom<String>): ObservableUseCase<String> {
    override fun execute(): Observable<String> = randomString.generate()
}