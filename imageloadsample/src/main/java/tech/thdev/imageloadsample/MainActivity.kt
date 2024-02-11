package tech.thdev.imageloadsample

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import tech.thdev.imageloadsample.databinding.ActivityMainBinding
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
        "https://github.com/taehwandev/Kotlin-Udemy-Sample/blob/No42-Image-load-library/app/src/main/res/drawable/sample_10.png?raw=true"
    )

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        loadTest()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.run {
            inflate(R.menu.main_menu, menu)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
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
                ImageDownloadAsync.loadImage(
                    R.drawable.ic_image_black_100dp,
                    activityMainBinding.imageView,
                    imageList[randNumber],
                    activityMainBinding.tvTitle,
                    randNumber + 1
                ).takeIf { it }?.let {
                    activityMainBinding.tvTitle.text = "ACTION_ASYNC cacheLoad : true - $randNumber"
                }
            }

            ACTION_THREAD -> {
                ImageDownloadThread.loadImage(
                    R.drawable.ic_image_black_100dp,
                    activityMainBinding.imageView,
                    imageList[randNumber],
                    activityMainBinding.tvTitle,
                    randNumber + 1
                ).takeIf { it }?.let {
                    activityMainBinding.tvTitle.text =
                        "ACTION_THREAD cacheLoad : true - $randNumber"
                }
            }
        }
    }
}
