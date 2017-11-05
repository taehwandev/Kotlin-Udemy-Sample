package tech.thdev.imageloadsample

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import tech.thdev.imageloadsample.util.random

class MainActivity : AppCompatActivity() {

    companion object {
        const val ACTION_ASYNC = 0
        const val ACTION_THREAD = 1
    }

    private var actionType = ACTION_ASYNC
    private val imageList = listOf(
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_01.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_02.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_03.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_04.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_05.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_06.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_07.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_08.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_09.png?raw=true",
            "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_10.png?raw=true")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadTest()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater?.run {
            inflate(R.menu.main_menu, menu)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.action_reload -> {
                loadTest()
                true
            }
            R.id.action_async -> {
                actionType = ACTION_ASYNC
                loadTest()
                true
            }
            R.id.action_thread -> {
                actionType = ACTION_THREAD
                loadTest()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun loadTest() {
        val randNumber = (1..imageList.size).random()
        when (actionType) {
            ACTION_ASYNC -> {
                ImageDownloadAsync.loadImage(R.drawable.ic_image_black_100dp, image_view, imageList[randNumber], tv_title, randNumber + 1).takeIf { it }?.let {
                    tv_title.text = "ACTION_ASYNC cacheLoad : true - $randNumber"
                }
            }
            ACTION_THREAD -> {
                ImageDownloadThread.loadImage(R.drawable.ic_image_black_100dp, image_view, imageList[randNumber], tv_title, randNumber + 1).takeIf { it }?.let {
                    tv_title.text = "ACTION_THREAD cacheLoad : true - $randNumber"
                }
            }
        }
    }
}
