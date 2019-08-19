package tw.hankli.brookray.recyclerview.section

import android.os.Bundle
import android.view.View
import tw.hankli.brookray.BaseFragment
import tw.hankli.brookray.R

class SectionDemoFragment : BaseFragment() {

    companion object {
        fun newInstance(): SectionDemoFragment = SectionDemoFragment()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_demo_section

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}