package avila.domingo.domain

import io.reactivex.Observable

interface IRandom<T> {
    fun generate(): Observable<T>
}