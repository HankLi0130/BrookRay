package tw.hankli.brookray.core.extension

import androidx.fragment.app.Fragment

fun Fragment.getContentResolver() = requireContext().contentResolver