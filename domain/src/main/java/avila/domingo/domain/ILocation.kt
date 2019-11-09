package avila.domingo.domain


import avila.domingo.domain.model.Location
import io.reactivex.Completable
import io.reactivex.Observable

interface ILocation {
    fun getLocations(): Observable<Location>
    fun stopLocations(): Completable
}