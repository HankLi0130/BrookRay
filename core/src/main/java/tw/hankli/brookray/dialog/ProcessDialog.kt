package tw.hankli.brookray.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_process.*
import tw.hankli.brookray.R

class ProcessDialog : DialogFragment() {

    companion object {
        private const val KEY_TITLE = "title"
        private const val KEY_CANCELABLE = "cancelable"

        fun newInstance(title: String, cancelable: Boolean = false): ProcessDialog {
            val args = Bundle().apply {
                putString(KEY_TITLE, title)
                putBoolean(KEY_CANCELABLE, cancelable)
            }

            return ProcessDialog().apply {
                arguments = args
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_process, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view_progress_title.text = arguments?.getString(KEY_TITLE)
        isCancelable = arguments?.getBoolean(KEY_CANCELABLE) ?: false
    }
}