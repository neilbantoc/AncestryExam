package neilbantoc.ancestry.features.home

import androidx.databinding.ObservableField
import neilbantoc.ancestry.data.models.Course
import neilbantoc.framework.model.ViewState

class HomeState : ViewState() {
    var courses = ObservableField<List<Course>>()
}