package tw.hankli.brookray

import android.os.Bundle
import tw.hankli.library.view.activity.ContainerActivity

class MainActivity : ContainerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
