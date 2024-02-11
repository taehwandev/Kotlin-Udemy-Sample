package tech.thdev.list_view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tech.thdev.list_view.adapter.NonViewHolderPatternAdapter
import tech.thdev.list_view.adapter.ViewHolderPatternAdapter
import tech.thdev.list_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.listViewNonViewHolderPattern.adapter =
            NonViewHolderPatternAdapter(this, 0, getList())
        activityMainBinding.listViewViewHolderPattern.adapter =
            ViewHolderPatternAdapter(this, 0, getList())

        activityMainBinding.btnRecyclerView.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
    }

    private fun getList(): List<String> {
        return (0..100).map { "Index $it" }
    }
}
