package neilbantoc.ancestry.features.home

import neilbantoc.ancestry.api.ApiServices
import neilbantoc.framework.base.BasePresenter

class HomePresenter(state: HomeState,  view: HomeView, container: HomeContainer, val apiServices: ApiServices) : BasePresenter<HomeState, HomeView, HomeContract.View.Actions, HomeContainer>(state, view, container), HomeContract.View.EventHandler {
    override fun initDatabinding() {
        view.dataBinding.eventhandler = this
        view.dataBinding.state = state
    }

    override fun onViewInitialized() {
        super.onViewInitialized()
        if (state.courses.get() == null) {
            addDisposable(apiServices.getHomeFeed().subscribe({ response ->
                state.courses.set(response.courses)
            }, {
                it.printStackTrace()
            }))
        }

        addDisposable(view.actions.onCourseClick.observable().subscribe { course ->
            container.showDetail(course.id)
        })
    }

}