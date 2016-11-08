package tech.thdev.listviewsample.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import tech.thdev.listviewsample.R

/**
 * Created by tae-hwan on 11/8/16.
 */

class SimpleAdapter(context: Context, resource: Int, objects: List<String>) :
        ArrayAdapter<String>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view = LayoutInflater.from(context).inflate(R.layout.item_simple, parent, false)
        val textView = view.findViewById(R.id.tv_message) as TextView
        textView.text = getItem(position)
        Log.d("TAG", "getView")
        return view
    }
}