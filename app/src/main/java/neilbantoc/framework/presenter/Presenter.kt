package neilbantoc.framework.presenter

import neilbantoc.framework.container.LifecycleEvents
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

interface Presenter: Consumer<LifecycleEvents> {
    fun getDisposables(): CompositeDisposable
    fun addDisposable(disposable: Disposable)
}