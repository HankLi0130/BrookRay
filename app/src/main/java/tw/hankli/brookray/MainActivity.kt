package tw.hankli.brookray

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import tw.hankli.brookray.dialog.ProcessDialog

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        view_btn.setOnClickListener {
            val dialog = ProcessDialog.newInstance("請稍候．．．")
            dialog.show(supportFragmentManager, "dialog")
        }
    }
}
