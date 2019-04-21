package neilbantoc.ancestry.features.home

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import neilbantoc.ancestry.base.BaseActivity

class HomeContainer(): HomeContract.Container, BaseActivity() {
    override fun showDetail(courseId: Number) {
        Toast.makeText(this, "Course: " + courseId, Toast.LENGTH_LONG).show()
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
