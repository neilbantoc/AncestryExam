package neilbantoc.ancestry.features.coursedetails

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import neilbantoc.ancestry.base.BaseActivity

class CourseDetailsContainer : BaseActivity(), CourseDetailsContract.Container {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val state = ViewModelProviders.of(this).get(CourseDetailsState::class.java)
        setupState(state, intent)
        val view = CourseDetailsView()
        val presenter = CourseDetailsPresenter(state, view, this, getApp().apiServices)
        presenter.initPresenter(this)
        setContentView(view.getContentView())
    }

    private fun setupState(state: CourseDetailsState, intent: Intent) {
        state.courseId.set(intent.getLongExtra(COURSE_ID, -1))
        state.bannerUrl.set(intent.getStringExtra(BANNER_URL))
        state.courseTitle.set(intent.getStringExtra(COURSE_TITLE))
    }

    override fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    companion object {
        private const val COURSE_ID = "course_id"
        private const val BANNER_URL = "banner_url"
        private const val COURSE_TITLE = "course_title"

        @JvmStatic
        fun createIntent(context: Context, courseId: Long, bannerUrl: String, courseTitle: String) : Intent {
            val intent = Intent(context, CourseDetailsContainer::class.java)
            intent.putExtra(COURSE_ID, courseId)
            intent.putExtra(BANNER_URL, bannerUrl)
            intent.putExtra(COURSE_TITLE, courseTitle)
            return intent
        }
    }
}