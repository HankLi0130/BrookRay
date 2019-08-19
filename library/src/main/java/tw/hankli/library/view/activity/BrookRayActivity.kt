package tw.hankli.library.view.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import tw.hankli.library.ext.*
import tw.hankli.library.utils.NO_RESOURCE

/**
 * Fragment container activity.
 */

abstract class BrookRayActivity : AppCompatActivity() {

    open val containerId: Int = NO_RESOURCE

    /** 加入 Fragment */
    fun add(
        fragment: Fragment,
        now: Boolean = false,
        allowStateLoss: Boolean = false,
        addToBackStack: Boolean = false,
        name: String? = null
    ) {
        supportFragmentManager.add(
            containerId,
            fragment,
            fragment.getSimpleName(),
            now,
            allowStateLoss,
            addToBackStack,
            name
        )
    }

    /** 加入新的 Fragment，並隱藏原本 Fragment */
    fun hideAndAdd(
        hideFragment: Fragment,
        addedFragment: Fragment,
        now: Boolean = false,
        allowStateLoss: Boolean = false,
        addToBackStack: Boolean = false,
        name: String? = null
    ) {
        supportFragmentManager.hideAndAdd(
            containerId,
            hideFragment,
            addedFragment,
            addedFragment.getSimpleName(),
            now,
            allowStateLoss,
            addToBackStack,
            name
        )
    }

    /** 取代 Fragment */
    fun replace(
        fragment: Fragment,
        now: Boolean = false,
        allowStateLoss: Boolean = false,
        addToBackStack: Boolean = false,
        name: String? = null
    ) {
        supportFragmentManager.replace(
            containerId,
            fragment,
            fragment.getSimpleName(),
            now,
            allowStateLoss,
            addToBackStack,
            name
        )
    }

    /** 移除 Fragment */
    fun remove(
        fragment: Fragment,
        now: Boolean = false,
        allowStateLoss: Boolean = false,
        addToBackStack: Boolean = false,
        name: String? = null
    ) {
        supportFragmentManager.remove(fragment, now, allowStateLoss, addToBackStack, name)
    }

    fun clearBackStack(immediate: Boolean = false) {
        supportFragmentManager.popBackStack(immediate, true, null)
    }
}