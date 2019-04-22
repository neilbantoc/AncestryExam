package neilbantoc.ancestry.features.coursedetails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import neilbantoc.ancestry.BR
import neilbantoc.ancestry.R
import neilbantoc.ancestry.data.models.Video
import neilbantoc.ancestry.databinding.ActivityCourseDetailsBinding
import neilbantoc.ancestry.databinding.ItemCourseVideoBinding
import neilbantoc.framework.base.BaseView
import neilbantoc.framework.utils.BindableAdapter


class CourseDetailsView() : CourseDetailsContract.View, BaseView<CourseDetailsState, CourseDetailsContract.View.Actions, ActivityCourseDetailsBinding>(R.layout.activity_course_details, CourseDetailsContract.View.Actions()) {

    override fun initView(context: Context) {
        super.initView(context)
        dataBinding.recyclerView.layoutManager = LinearLayoutManager(getContext())
        dataBinding.recyclerView.adapter = VideosAdapter(actions)
    }

    override fun toastError(throwable: Throwable) {
        Toast.makeText(getContext(), throwable.message, Toast.LENGTH_LONG).show()
    }

    class VideosAdapter(val actions: CourseDetailsContract.View.Actions) : RecyclerView.Adapter<VideosAdapter.Holder>(), BindableAdapter<List<Video>?> {

        private val items = ArrayList<Video>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val inflater = LayoutInflater.from(parent.context)
            val dataBinding = DataBindingUtil.inflate<ItemCourseVideoBinding>(inflater, R.layout.item_course_video, parent,  false)
            return Holder(dataBinding, actions)
        }

        override fun getItemCount(): Int {
            return items.size
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.bind(items.get(position))
        }

        override fun setData(data: List<Video>?) {
            items.clear()
            data?.apply {
                items.addAll(data)
            }
            notifyDataSetChanged()
        }

        class Holder(val dataBinding: ViewDataBinding, val actions: CourseDetailsContract.View.Actions) : View.OnClickListener, RecyclerView.ViewHolder(dataBinding.root) {
            lateinit var video: Video

            init {
                dataBinding.root.setOnClickListener(this)
            }

            override fun onClick(v: View?) {
                actions.onVideoClick.publish(video)
            }

            fun bind(video: Video) {
                this.video = video
                dataBinding.setVariable(BR.video, video)
                dataBinding.executePendingBindings()
            }
        }
    }
}