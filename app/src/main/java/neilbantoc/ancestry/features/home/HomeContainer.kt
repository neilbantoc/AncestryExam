package neilbantoc.ancestry.features.home

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import neilbantoc.ancestry.base.BaseActivity
import neilbantoc.ancestry.features.coursedetails.CourseDetailsContainer

class HomeContainer(): HomeContract.Container, BaseActivity() {
    override fun showDetail(courseId: Long) {
        val intent = CourseDetailsContainer.createIntent(this, courseId)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val state = ViewModelProviders.of(this).get(HomeState::class.java)
        val view = HomeView()
        val presenter = HomePresenter(state, view, this, getApp().apiServices)
        presenter.initPresenter(this)
        setContentView(view.getContentView())
    }
}
