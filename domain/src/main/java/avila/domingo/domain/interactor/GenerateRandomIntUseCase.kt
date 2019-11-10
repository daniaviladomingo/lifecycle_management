package avila.domingo.domain.interactor

import avila.domingo.domain.IRandom
import avila.domingo.domain.interactor.type.ObservableUseCase
import io.reactivex.Observable

class GenerateRandomIntUseCase(private val randomInt: IRandom<Int>): ObservableUseCase<Int> {
    override fun execute(): Observable<Int> = randomInt.generate()
}