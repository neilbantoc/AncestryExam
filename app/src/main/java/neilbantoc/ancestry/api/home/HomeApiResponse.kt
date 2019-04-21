package neilbantoc.ancestry.api.home

import com.google.gson.annotations.SerializedName
import neilbantoc.ancestry.data.models.Course
import neilbantoc.ancestry.data.models.User

data class HomeApiResponse(
    @SerializedName("user") val user: User,
    @SerializedName("videos") val courses: List<Course>
)