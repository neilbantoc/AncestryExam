package neilbantoc.framework.presenter

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import neilbantoc.framework.container.LifecycleEvents

interface Presenter: Consumer<LifecycleEvents> {
    fun getDisposables(): CompositeDisposable
    fun addDisposable(disposable: Disposable)
}