package tw.hankli.library.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tw.hankli.library.ext.setTitle
import tw.hankli.library.utils.NO_RESOURCE

abstract class CommonFragment : Fragment() {

    open val titleId: Int = NO_RESOURCE

    open val layoutRes: Int = NO_RESOURCE

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return if (layoutRes == NO_RESOURCE) super.onCreateView(inflater, container, savedInstanceState)
        else inflater.inflate(layoutRes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setTitle(titleId)
    }
}