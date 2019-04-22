package neilbantoc.ancestry.features.coursedetails

import neilbantoc.framework.container.LifecycleContainer
import neilbantoc.framework.view.ObservableViewActions

class CourseDetailsContract {
    interface View : neilbantoc.framework.view.View<View.Actions> {

        interface EventHandler

        class Actions : ObservableViewActions
    }

    interface Container : LifecycleContainer
}