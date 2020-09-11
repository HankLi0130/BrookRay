package tw.hankli.brookray

import android.os.Bundle
import tw.hankli.library.ui.activity.BrookRayActivity

class MainActivity : BrookRayActivity() {

    override val containerId: Int
        get() = R.id.view_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            replace(MainFragment.newInstance())
        }
    }
}
