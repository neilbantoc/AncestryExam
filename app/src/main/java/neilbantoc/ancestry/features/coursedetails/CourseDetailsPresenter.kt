package neilbantoc.ancestry.features.coursedetails

import neilbantoc.ancestry.api.ApiServices
import neilbantoc.framework.base.BasePresenter

class CourseDetailsPresenter(state: CourseDetailsState, view: CourseDetailsView, container: CourseDetailsContainer, val apiServices: ApiServices) : CourseDetailsContract.View.EventHandler, BasePresenter<CourseDetailsState, CourseDetailsView, CourseDetailsContract.View.Actions, CourseDetailsContainer>(state, view, container) {
    override fun initDatabinding() {
        view.dataBinding.eventhandler = this
        view.dataBinding.state = state
    }

    override fun onViewInitialized() {
        state.courseId.get()?.apply {
            addDisposable(apiServices.getCourseDetail(state.courseId.get()!!).subscribe( { videos ->
                state.videos.set(videos)
            }, { error ->
                error.printStackTrace()
            }))
        }
    }
}