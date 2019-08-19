package tw.hankli.library.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.transaction

// pop transaction 包含指定的 name
const val POP_BACK_STACK_INCLUSIVE = FragmentManager.POP_BACK_STACK_INCLUSIVE

// pop transaction 不包含指定的 name
const val POP_BACK_STACK = 0

/** 執行 Fragment Transaction */
fun FragmentManager.makeTransaction(
    now: Boolean = false,
    allowStateLoss: Boolean = false,
    addToBackStack: Boolean = false,
    name: String? = null,
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
    tag: String? = null,
    now: Boolean = false,
    allowStateLoss: Boolean = false,
    addToBackStack: Boolean = false,
    name: String? = null
) {
    makeTransaction(now, allowStateLoss, addToBackStack, name) {
        add(containerId, fragment, tag)
    }
}

/** 加入新的 Fragment，並隱藏原本 Fragment */
fun FragmentManager.hideAndAdd(
    containerId: Int,
    hideFragment: Fragment,
    addedFragment: Fragment,
    tag: String? = null,
    now: Boolean = false,
    allowStateLoss: Boolean = false,
    addToBackStack: Boolean = false,
    name: String? = null
) {
    makeTransaction(now, allowStateLoss, addToBackStack, name) {
        hide(hideFragment)
        add(containerId, addedFragment, tag)
    }
}

/** 取代 Fragment */
fun FragmentManager.replace(
    containerId: Int,
    fragment: Fragment,
    tag: String? = null,
    now: Boolean = false,
    allowStateLoss: Boolean = false,
    addToBackStack: Boolean = false,
    name: String? = null
) {
    makeTransaction(now, allowStateLoss, addToBackStack, name) {
        replace(containerId, fragment, tag)
    }
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

fun FragmentManager.popBackStack(immediate: Boolean = false) {
    if (immediate) popBackStackImmediate() else popBackStack()
}

fun FragmentManager.popBackStack(immediate: Boolean = false, inclusive: Boolean = false, id: Int) {
    if (immediate) {
        if (inclusive) popBackStackImmediate(id, POP_BACK_STACK_INCLUSIVE)
        else popBackStackImmediate(id, POP_BACK_STACK)
    } else {
        if (inclusive) popBackStack(id, POP_BACK_STACK_INCLUSIVE)
        else popBackStack(id, POP_BACK_STACK)
    }
}

/**
 * @param name name is the addToBackStack() parameter
 */
fun FragmentManager.popBackStack(immediate: Boolean = false, inclusive: Boolean = false, name: String? = null) {
    if (immediate) {
        if (inclusive) popBackStackImmediate(name, POP_BACK_STACK_INCLUSIVE)
        else popBackStackImmediate(name, POP_BACK_STACK)
    } else {
        if (inclusive) popBackStack(name, POP_BACK_STACK_INCLUSIVE)
        else popBackStack(name, POP_BACK_STACK)
    }
}