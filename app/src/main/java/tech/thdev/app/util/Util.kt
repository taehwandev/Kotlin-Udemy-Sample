package tech.thdev.app.util

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by record-tae on 10/21/17.
 */
fun AppCompatActivity.replace(@IdRes frameId: Int, fragment: Fragment, tag: String? = null) {
    supportFragmentManager.beginTransaction().replace(frameId, fragment, tag).commit()
}

fun ClosedRange<Int>.random() =
    Random().nextInt(endInclusive - start)

fun String.decimalFormat(): String {
    return DecimalFormat("#,###").format(this.toLong())
}

fun String.getDate(dateFormat: String): String {
    val calendar = Calendar.getInstance().apply {
        timeInMillis = this@getDate.toLong() * 1000
    }
    return SimpleDateFormat(dateFormat, Locale.getDefault()).format(calendar.time)
}