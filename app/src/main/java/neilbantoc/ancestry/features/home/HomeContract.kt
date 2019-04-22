package neilbantoc.ancestry.features.home

import neilbantoc.ancestry.data.models.Course
import neilbantoc.framework.container.LifecycleContainer
import neilbantoc.framework.view.ObservableViewActions
import neilbantoc.framework.view.ViewAction

class HomeContract {
    interface View: neilbantoc.framework.view.View<View.Actions> {

        fun toastError(throwable: Throwable)

        interface EventHandler

        class Actions : ObservableViewActions {
            val onCourseClick = ViewAction<Course>()
        }
    }

    interface Container: LifecycleContainer {
        fun showDetail(courseId: Long, bannerUrl: String, title: String)
    }
}