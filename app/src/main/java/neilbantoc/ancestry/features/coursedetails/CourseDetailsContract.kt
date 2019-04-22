package neilbantoc.ancestry.features.coursedetails

import neilbantoc.ancestry.data.models.Video
import neilbantoc.framework.container.LifecycleContainer
import neilbantoc.framework.view.ObservableViewActions
import neilbantoc.framework.view.ViewAction

class CourseDetailsContract {
    interface View : neilbantoc.framework.view.View<View.Actions> {

        fun toastError(throwable: Throwable)

        interface EventHandler

        class Actions : ObservableViewActions {
            val  onVideoClick = ViewAction<Video>()
        }
    }

    interface Container : LifecycleContainer {
        fun openUrl(url: String)
    }
}