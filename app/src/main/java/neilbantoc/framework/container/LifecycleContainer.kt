package neilbantoc.framework.container

import io.reactivex.Observable

interface LifecycleContainer: Container {
    fun observeLifecycle(): Observable<LifecycleEvents>

    fun finish()
}