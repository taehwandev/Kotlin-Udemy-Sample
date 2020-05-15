package tech.thdev.listviewsample.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_simple.view.*
import tech.thdev.listviewsample.R

/**
 * Created by tae-hwan on 11/8/16.
 */

class ViewHolderAdapter(context: Context, resource: Int, objects: List<String>) :
    ArrayAdapter<String>(context, resource, objects) {

    private lateinit var view: View
    private var viewHolder: ViewHolder? = null

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_simple, parent, false)
            viewHolder = ViewHolder(view)

            view?.tag = viewHolder
            Log.i("TAG", "create viewHolder")

        } else {
            view = convertView
            viewHolder = view?.tag as ViewHolder
            Log.i("TAG", "viewHolder getTag")
        }
        viewHolder?.bindView(getItem(position))
        return view
    }


    inner class ViewHolder(val itemView: View?) {

        fun bindView(item: String?) {
            itemView?.let {
                with(it) {
                    tv_message.text = item
                }
            }
        }
    }
}