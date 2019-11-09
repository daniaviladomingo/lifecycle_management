package avila.domingo.domain.interactor

import avila.domingo.domain.ILocation
import avila.domingo.domain.interactor.type.CompletableUseCase
import io.reactivex.Completable

class StopLocationsUseCase(private val location: ILocation) : CompletableUseCase {
    override fun execute(): Completable = location.stopLocations()
}