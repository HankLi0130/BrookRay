package tw.hankli.brookray.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.viewOf(layoutRes: Int): View {
    return LayoutInflater.from(this.context).inflate(layoutRes, this, false)
}