package tech.thdev.imageloadsample.util

import java.util.*

/**
 * Created by record-tae on 10/21/17.
 */
fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start)