package neilbantoc.ancestry

import android.app.Application
import io.reactivex.exceptions.UndeliverableException
import io.reactivex.plugins.RxJavaPlugins
import neilbantoc.ancestry.api.ApiServices
import neilbantoc.ancestry.api.course.CourseApi
import neilbantoc.ancestry.api.home.HomeApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class App() : Application() {

    lateinit var apiServices: ApiServices

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl(Config.currentConfig.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        apiServices = ApiServices(retrofit.create(HomeApi::class.java), retrofit.create(CourseApi::class.java))

        RxJavaPlugins.setErrorHandler { e ->
            if (e is UndeliverableException) {
                e.printStackTrace()
            } else {
                Thread.currentThread().also { thread ->
                    thread.uncaughtExceptionHandler.uncaughtException(thread, e)
                }
            }
        }
    }
}