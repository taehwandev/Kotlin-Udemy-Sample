package tech.thdev.kotlin_udemy_sample.view.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import tech.thdev.kotlin_udemy_sample.R

/**
 * Created by tae-hwan on 10/3/16.
 */
class MainFragment : Fragment() {

    private val etNumberOne by lazy {
        view?.findViewById(R.id.number_one) as EditText
    }

    private var etNumberTwo: EditText? = null

    // Java 식의 static instance
    companion object {
        fun getInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater?.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etNumberTwo = view?.findViewById(R.id.number_two) as EditText

        val textView = view?.findViewById(R.id.text) as TextView
        val button = view?.findViewById(R.id.button) as Button
        button.setOnClickListener {
            textView.text = getSum().toString()
        }
    }

    private fun getSum(): Int {
        val one = try {
            etNumberOne.text.toString().toInt()

        } catch (e: Exception) {
            0
        }

        val two = when {
            etNumberTwo?.text?.isNullOrEmpty() as Boolean -> 0
            else -> etNumberTwo?.text?.toString()?.toInt()
        } ?: 0

        return one + two
    }
}