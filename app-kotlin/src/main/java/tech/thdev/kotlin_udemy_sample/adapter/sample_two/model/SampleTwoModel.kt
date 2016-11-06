package tech.thdev.kotlin_udemy_sample.adapter.sample_two.model

import tech.thdev.kotlin_udemy_sample.data.SampleItem
import java.util.*

/**
 * Created by tae-hwan on 11/4/16.
 */

interface SampleTwoModel {

    fun addItem(sampleItem: SampleItem)

    fun getItem(position: Int): SampleItem?

    /**
     * Item을 제거한다
     */
    fun removeItem(sampleItem: SampleItem)

    fun getItems(): MutableList<SampleItem>
}