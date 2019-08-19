package tw.hankli.brookray

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_main.*
import tw.hankli.brookray.recyclerview.section.SectionDemoFragment

class MainFragment : BaseFragment() {

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view_btn0.setOnClickListener {
            replace(SectionDemoFragment.newInstance(), addToBackStack = true, name = "SectionDemo")
        }
    }
}