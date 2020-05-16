package tech.thdev.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import tech.thdev.list.adapter.NonViewHolderPatternAdapter
import tech.thdev.list.adapter.ViewHolderPatternAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list_view_non_view_holder_pattern.adapter = NonViewHolderPatternAdapter(this, 0, getList())
        list_view_view_holder_pattern.adapter = ViewHolderPatternAdapter(this, 0, getList())

        btn_recycler_view.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
    }

    private fun getList(): List<String> {
        return (0..100).map { "Index $it" }
    }
}
