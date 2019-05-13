package tw.hankli.library.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.transaction

const val BACK_STACK_ROOT_TAG = "rootFragment"

/** 執行 Fragment Transaction */
fun FragmentManager.makeTransaction(
    now: Boolean,
    allowStateLoss: Boolean,
    addToBackStack: Boolean,
    name: String?,
    method: FragmentTransaction.() -> Unit
) {
    transaction(now, allowStateLoss) {
        method()
        if (addToBackStack) addToBackStack(name)
    }
}

/** 加入 Fragment */
fun FragmentManager.add(
    containerId: Int,
    fragment: Fragment,
    now: Boolean = false,
    allowStateLoss: Boolean = false,
    addToBackStack: Boolean = false,
    name: String? = null
) {
    makeTransaction(now, allowStateLoss, addToBackStack, name) {
        add(containerId, fragment, fragment.getName())
    }
}

/** 加入新的 Fragment，並隱藏原本 Fragment */
fun FragmentManager.addAndHide(
    containerId: Int,
    addedFragment: Fragment,
    hideFragment: Fragment,
    now: Boolean = false,
    allowStateLoss: Boolean = false,
    addToBackStack: Boolean = false,
    name: String? = null
) {
    makeTransaction(now, allowStateLoss, addToBackStack, name) {
        hide(hideFragment)
        add(containerId, addedFragment, addedFragment.getName())
    }
}

/** 取代 Fragment */
fun FragmentManager.replace(
    containerId: Int,
    fragment: Fragment,
    now: Boolean = false,
    allowStateLoss: Boolean = false,
    addToBackStack: Boolean = false,
    name: String? = null
) {
    makeTransaction(now, allowStateLoss, addToBackStack, name) {
        replace(containerId, fragment, fragment.getName())
    }
}

/**  清除之前的 Fragment 並取代 Fragment */
fun FragmentManager.replaceOnTop(
    containerId: Int,
    fragment: Fragment,
    now: Boolean = false,
    allowStateLoss: Boolean = false,
    addToBackStack: Boolean = false,
    name: String? = null
) {
    popBackStack(now)
    replace(containerId, fragment, now, allowStateLoss, addToBackStack, name)
}

/** 清除之前的 Fragment */
fun FragmentManager.popBackStack(now: Boolean = false, name: String? = null) {

    val flags = FragmentManager.POP_BACK_STACK_INCLUSIVE

    if (now) this.popBackStackImmediate(name, flags)
    else this.popBackStack(name, flags)
}

/** 移除 Fragment */
fun FragmentManager.remove(
    fragment: Fragment,
    now: Boolean = false,
    allowStateLoss: Boolean = false,
    addToBackStack: Boolean = false,
    name: String? = null
) {
    makeTransaction(now, allowStateLoss, addToBackStack, name) {
        remove(fragment)
    }
}