package neilbantoc.ancestry.api.course

import io.reactivex.Single
import neilbantoc.ancestry.data.models.Video
import retrofit2.http.GET
import retrofit2.http.Query

interface CourseApi {
    @GET("course_detail")
    fun getCourseDetail(@Query("id") courseId: Number): Single<List<Video>>

}