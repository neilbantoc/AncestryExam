package neilbantoc.ancestry.features.coursedetails

import android.util.Patterns
import neilbantoc.ancestry.api.ApiServices
import neilbantoc.framework.base.BasePresenter
import java.net.MalformedURLException

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
                view.toastError(error)
            }))
        }

        addDisposable(view.actions.onVideoClick.observable().subscribe({ video ->
            val url = video.link
            if (Patterns.WEB_URL.matcher(url).matches()) {
                container.openUrl(video.link)
            } else {
                view.toastError(MalformedURLException("Link is invalid"))
            }
        }, { error ->
            view.toastError(error)
        }))
    }
}