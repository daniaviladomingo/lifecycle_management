package avila.domingo.domain.interactor

import avila.domingo.domain.ILocation
import avila.domingo.domain.interactor.type.ObservableUseCase
import avila.domingo.domain.model.Location
import io.reactivex.Observable

class GetLocationsUseCase(private val location: ILocation) : ObservableUseCase<Location> {
    override fun execute(): Observable<Location> = location.getLocations()
}