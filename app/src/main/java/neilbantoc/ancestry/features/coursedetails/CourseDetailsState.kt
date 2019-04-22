package neilbantoc.ancestry.features.coursedetails

import androidx.databinding.ObservableField
import neilbantoc.ancestry.data.models.Course
import neilbantoc.ancestry.data.models.Video
import neilbantoc.framework.model.ViewState

class CourseDetailsState : ViewState() {
    val courseId = ObservableField<Number>()
    val videos = ObservableField<List<Video>>()
}