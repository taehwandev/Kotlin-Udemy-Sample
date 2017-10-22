package tech.thdev.list.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import tech.thdev.list.R

/**
 * Created by tae-hwan on 10/22/17.
 */
class NonViewHolderPatternAdapter(context: Context, resource: Int, objects: List<String>) : ArrayAdapter<String>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        val textView = view.findViewById<TextView>(R.id.tv_message)
        textView.text = getItem(position)
        Log.d("TAG", "getView")
        return view
    }
}