package tech.thdev.list_view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import tech.thdev.list_sample.R

/**
 * Created by tae-hwan on 10/22/17.
 */
class ViewHolderPatternAdapter(context: Context, resource: Int, objects: List<String>) :
    ArrayAdapter<String>(context, resource, objects) {

    private lateinit var view: View
    private lateinit var viewHolder: ViewHolder

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
            viewHolder = ViewHolder(view)

            view.tag = viewHolder
            Log.i("TAG", "create viewHolder")

        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
            Log.i("TAG", "viewHolder getTag")
        }
        viewHolder.bindView(getItem(position))
        return view
    }

    class ViewHolder(private val itemView: View?) {

        private val tvMessage: TextView? by lazy {
            itemView?.findViewById(R.id.tv_message)
        }

        fun bindView(item: String?) {
            tvMessage?.text = item ?: ""
        }
    }
}