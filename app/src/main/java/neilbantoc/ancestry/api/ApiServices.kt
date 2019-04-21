package neilbantoc.ancestry.api

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import neilbantoc.ancestry.api.course.CourseApi
import neilbantoc.ancestry.api.home.HomeApi
import neilbantoc.ancestry.api.home.HomeApiResponse
import neilbantoc.ancestry.data.models.Video

class ApiServices(private val homeApi: HomeApi, private val courseApi: CourseApi) {
    fun getHomeFeed(): Single<HomeApiResponse> {
        return homeApi.getHomeFeed()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getCourseDetail( courseId: Number): Single<List<Video>> {
        return courseApi.getCourseDetail(courseId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}