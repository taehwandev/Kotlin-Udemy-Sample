package tech.thdev.kotlin_udemy_sample.adapter.sample_one.model

import tech.thdev.kotlin_udemy_sample.data.SampleItem

/**
 * Created by tae-hwan on 11/4/16.
 */

interface SampleOneModel {

    fun addItem(sampleItem: SampleItem)

    fun getItem(position: Int): SampleItem?

    fun getItemCount(): Int

    fun  removeItem(sampleItem: SampleItem)
}