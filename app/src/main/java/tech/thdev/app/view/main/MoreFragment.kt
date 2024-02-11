package tech.thdev.app.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tech.thdev.app.databinding.FragmentHomeBinding

/**
 * Created by record-tae on 10/21/17.
 */
class MoreFragment : Fragment() {

    companion object {
        val KEY_TITLE = "key-title"
    }

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        FragmentHomeBinding.inflate(inflater, container, false).also {
            fragmentHomeBinding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentHomeBinding.message.setText(arguments?.getInt(KEY_TITLE) ?: 0)
    }
}