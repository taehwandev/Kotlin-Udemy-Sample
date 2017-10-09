package tech.thdev.app.view.main.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import tech.thdev.app.R

/**
 * Created by record-tae on 10/10/17.
 */

class HomeFragment : Fragment() {

    companion object {
        val STRING_RES = "string-res"

        fun getInstance(stringRes: Int): HomeFragment {
            val fragment = HomeFragment()
            fragment.arguments = Bundle().apply {
                putInt(STRING_RES, stringRes)
            }
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?)
        = inflater?.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val stringRes = arguments.getInt(STRING_RES)
        message.setText(stringRes)
    }
}