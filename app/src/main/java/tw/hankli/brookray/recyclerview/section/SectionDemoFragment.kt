package tw.hankli.brookray.recyclerview.section

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_demo_section.*
import tw.hankli.brookray.BaseFragment
import tw.hankli.brookray.R

class SectionDemoFragment : BaseFragment() {

    companion object {
        fun newInstance(): SectionDemoFragment = SectionDemoFragment()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_demo_section

    private val adapter = SectionDemoAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view_list.setHasFixedSize(true)
        view_list.adapter = adapter

        adapter.items = getMap()
    }

    private fun getMap(): Map<String, List<String>> {
        val quebec = listOf(
            "Acton Vale",
            "Alma",
            "Amos",
            "Amqui",
            "Asbestos"
        )

        val ontario = listOf(
            "Barrie",
            "Belleville",
            "Brampton",
            "Brant",
            "Brantford",
            "Brockville",
            "Burlington"
        )

        val britishColumbia = listOf(
            "Campbell River",
            "Castlegar",
            "Chilliwack",
            "Colwood",
            "Coquitlam",
            "Courtenay",
            "Cranbrook"
        )

        return mapOf(
            "Quebec" to quebec,
            "Ontario" to ontario,
            "British Columbia" to britishColumbia
        )
    }
}