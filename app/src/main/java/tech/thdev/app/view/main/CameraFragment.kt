package tech.thdev.app.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tech.thdev.app.databinding.FragmentEtcBinding

/**
 * Created by record-tae on 10/21/17.
 */
class CameraFragment : Fragment() {

    companion object {
        const val KEY_TITLE = "key-title"
    }

    private lateinit var fragmentEtcBinding: FragmentEtcBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentEtcBinding.inflate(inflater, container, false).also {
            fragmentEtcBinding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentEtcBinding.message.setText(arguments?.getInt(KEY_TITLE) ?: 0)
    }
}