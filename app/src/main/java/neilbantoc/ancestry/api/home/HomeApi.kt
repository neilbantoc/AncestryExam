package neilbantoc.ancestry.api.home

import io.reactivex.Single
import retrofit2.http.GET

interface HomeApi {
    @GET("home_feed")
    fun getHomeFeed(): Single<HomeApiResponse>
}