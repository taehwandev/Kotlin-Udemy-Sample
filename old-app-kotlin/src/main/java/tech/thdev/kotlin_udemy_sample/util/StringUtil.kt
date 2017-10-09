package tech.thdev.kotlin_udemy_sample.util

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by tae-hwan on 11/15/16.
 */

fun String.decimalFormat(): String {
    return DecimalFormat("#,###").format(this.toLong())
}

fun String.getDate(dateFormat: String): String {
    val calendar = Calendar.getInstance().apply {
        timeInMillis = this@getDate.toLong() * 1000
    }
    return SimpleDateFormat(dateFormat, Locale.getDefault()).format(calendar.time)
}