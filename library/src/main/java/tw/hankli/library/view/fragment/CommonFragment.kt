package tw.hankli.library.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tw.hankli.library.utils.NO_RESOURCE

abstract class CommonFragment : Fragment() {

    open val layoutRes: Int = NO_RESOURCE

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return if (layoutRes == NO_RESOURCE) super.onCreateView(inflater, container, savedInstanceState)
        else inflater.inflate(layoutRes, container, false)
    }
}