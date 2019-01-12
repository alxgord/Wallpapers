package com.artto.wallpapers.utils

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single

fun <T> Observable<T>.with(observeOn: Scheduler, subscribeOn: Scheduler): Observable<T> =
    observeOn(observeOn).subscribeOn(subscribeOn)

fun <T> Single<T>.with(observeOn: Scheduler, subscribeOn: Scheduler): Single<T> =
    observeOn(observeOn).subscribeOn(subscribeOn)