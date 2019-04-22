package neilbantoc.ancestry.features.coursedetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import neilbantoc.ancestry.base.BaseActivity

class CourseDetailsContainer : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val state = ViewModelProviders.of(this).get(CourseDetailsState::class.java)
        state.courseId.set(intent.getLongExtra(COURSE_ID, -1))
        val view = CourseDetailsView()
        val presenter = CourseDetailsPresenter(state, view, this, getApp().apiServices)
        presenter.initPresenter(this)
        setContentView(view.getContentView())
    }

    companion object {
        private const val COURSE_ID = "course_id"

        @JvmStatic
        fun createIntent(context: Context, courseId: Long) : Intent {
            val intent = Intent(context, CourseDetailsContainer::class.java)
            intent.putExtra(COURSE_ID, courseId)
            return intent
        }
    }
}