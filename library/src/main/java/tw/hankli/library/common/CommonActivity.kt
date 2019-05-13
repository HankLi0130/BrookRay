package tw.hankli.library.common

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import tw.hankli.library.ext.BACK_STACK_ROOT_TAG
import tw.hankli.library.ext.getName
import tw.hankli.library.ext.makeTransaction
import tw.hankli.library.ext.popBackStack
import tw.hankli.library.utils.NO_RESOURCE

abstract class CommonActivity : AppCompatActivity() {

    open val containerId: Int = NO_RESOURCE

    /** 加入 Fragment */
    fun add(
        fragment: Fragment,
        now: Boolean = false,
        allowStateLoss: Boolean = false,
        addToBackStack: Boolean = false,
        name: String? = null
    ) {
        if (containerId == NO_RESOURCE) return

        supportFragmentManager.makeTransaction(now, allowStateLoss, addToBackStack, name) {
            add(containerId, fragment, fragment.getName())
        }
    }

    /** 加入新的 Fragment，並隱藏原本 Fragment */
    fun addAndHide(
        addedFragment: Fragment,
        hideFragment: Fragment,
        now: Boolean = false,
        allowStateLoss: Boolean = false,
        addToBackStack: Boolean = false,
        name: String? = null
    ) {
        if (containerId == NO_RESOURCE) return

        supportFragmentManager.makeTransaction(now, allowStateLoss, addToBackStack, name) {
            hide(hideFragment)
            add(containerId, addedFragment, addedFragment.getName())
        }
    }

    /** 取代 Fragment */
    fun replace(
        fragment: Fragment,
        now: Boolean = false,
        allowStateLoss: Boolean = false,
        addToBackStack: Boolean = false,
        name: String? = null
    ) {
        if (containerId == NO_RESOURCE) return

        supportFragmentManager.makeTransaction(now, allowStateLoss, addToBackStack, name) {
            replace(containerId, fragment, fragment.getName())
        }
    }

    /**  清除之前的 Fragment 並取代 Fragment */
    fun replaceOnTop(
        fragment: Fragment,
        now: Boolean = false,
        allowStateLoss: Boolean = false
    ) {
        if (containerId == NO_RESOURCE) return

        supportFragmentManager.popBackStack(now, BACK_STACK_ROOT_TAG)
        replace(fragment, now, allowStateLoss, true, BACK_STACK_ROOT_TAG)
    }

    /** 移除 Fragment */
    fun remove(
        fragment: Fragment,
        now: Boolean = false,
        allowStateLoss: Boolean = false,
        addToBackStack: Boolean = false,
        name: String? = null
    ) {
        if (containerId == NO_RESOURCE) return

        supportFragmentManager.makeTransaction(now, allowStateLoss, addToBackStack, name) {
            remove(fragment)
        }
    }
}