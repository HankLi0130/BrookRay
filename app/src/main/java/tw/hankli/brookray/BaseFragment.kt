package tw.hankli.brookray

import androidx.fragment.app.Fragment
import tw.hankli.library.ui.fragment.BrookRayFragment

abstract class BaseFragment : BrookRayFragment() {

    private fun getMainActivity(): MainActivity {
        return activity as MainActivity
    }

    /** 加入 Fragment */
    fun add(
        fragment: Fragment,
        now: Boolean = false, allowStateLoss: Boolean = false,
        addToBackStack: Boolean = false, name: String? = null
    ) {
        getMainActivity().add(fragment, now, allowStateLoss, addToBackStack, name)
    }

    /** 加入新的 Fragment，並隱藏原本 Fragment */
    fun hideAndHide(
        hideFragment: Fragment, addedFragment: Fragment,
        now: Boolean = false, allowStateLoss: Boolean = false,
        addToBackStack: Boolean = false, name: String? = null
    ) {
        getMainActivity().hideAndAdd(hideFragment, addedFragment, now, allowStateLoss, addToBackStack, name)
    }

    /** 取代 Fragment */
    fun replace(
        fragment: Fragment,
        now: Boolean = false, allowStateLoss: Boolean = false,
        addToBackStack: Boolean = false, name: String? = null
    ) {
        getMainActivity().replace(fragment, now, allowStateLoss, addToBackStack, name)
    }

    /** 移除 Fragment */
    fun remove(
        fragment: Fragment,
        now: Boolean = false, allowStateLoss: Boolean = false,
        addToBackStack: Boolean = false, name: String? = null
    ) {
        getMainActivity().remove(fragment, now, allowStateLoss, addToBackStack, name)
    }

    fun clearBackStack(immediate: Boolean = false) {
        getMainActivity().clearBackStack(immediate)
    }
}