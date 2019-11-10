package avila.domingo.domain.interactor

import avila.domingo.domain.IRandom
import avila.domingo.domain.interactor.type.ObservableUseCase
import io.reactivex.Observable

class GenerateRandomDoubleUseCase(private val randomDouble: IRandom<Double>): ObservableUseCase<Double> {
    override fun execute(): Observable<Double> = randomDouble.generate()
}