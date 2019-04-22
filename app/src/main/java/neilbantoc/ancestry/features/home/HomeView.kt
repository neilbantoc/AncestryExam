package neilbantoc.ancestry.features.home

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
import neilbantoc.ancestry.data.models.Course
import neilbantoc.ancestry.databinding.ActivityMainBinding
import neilbantoc.ancestry.databinding.ItemHomeCourseBinding
import neilbantoc.framework.base.BaseView
import neilbantoc.framework.utils.BindableAdapter

class HomeView() : BaseView<HomeState, HomeContract.View.Actions, ActivityMainBinding>(R.layout.activity_main, HomeContract.View.Actions()), HomeContract.View {

    override fun initView(context: Context) {
        super.initView(context)
        dataBinding.recyclerView.layoutManager = LinearLayoutManager(context)
        dataBinding.recyclerView.adapter = HomeAdapter(actions)
    }

    override fun toastError(throwable: Throwable) {
        Toast.makeText(getContext(), throwable.message, Toast.LENGTH_LONG).show()
    }

    class HomeAdapter(val actions: HomeContract.View.Actions) : RecyclerView.Adapter<HomeAdapter.Holder>(), BindableAdapter<List<Course>?> {

        private val items = ArrayList<Course>()

        override fun setData(data: List<Course>?) {
            items.clear()
            data?.apply {
                items.addAll(data)
            }
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.Holder {
            val inflater = LayoutInflater.from(parent.context)
            val dataBinding = DataBindingUtil.inflate<ItemHomeCourseBinding>(inflater, R.layout.item_home_course, parent, false)
            return Holder(dataBinding, actions)
        }

        override fun getItemCount(): Int {
            return items.size
        }

        override fun onBindViewHolder(holder: HomeAdapter.Holder, position: Int) {
            holder.bind(items.get(position))
        }

        class Holder(private val viewDataBinding: ViewDataBinding, private val actions: HomeContract.View.Actions) : View.OnClickListener, RecyclerView.ViewHolder(viewDataBinding.root) {

            lateinit var course: Course

            init {
                viewDataBinding.root.setOnClickListener(this)
            }

            override fun onClick(v: View?) {
                actions.onCourseClick.publish(course)
            }

            fun bind(course: Course) {
                this.course = course
                viewDataBinding.setVariable(BR.course, course)
                viewDataBinding.executePendingBindings()
            }
        }
    }


}