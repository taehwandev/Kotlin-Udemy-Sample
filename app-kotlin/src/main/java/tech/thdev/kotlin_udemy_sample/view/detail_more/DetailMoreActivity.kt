package tech.thdev.kotlin_udemy_sample.view.detail_more

import android.os.Bundle
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_detail_more.*
import tech.thdev.base.view.BaseActivity
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.constant.Constant
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem
import tech.thdev.kotlin_udemy_sample.view.detail_more.adapter.SectionsPagerAdapter

class DetailMoreActivity : BaseActivity(), ViewPager.OnPageChangeListener {

    private var selectionPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_more)

        setSupportActionBar(toolbar)
        title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val list = intent.getParcelableArrayListExtra<RecentPhotoItem>(Constant.KEY_PHOTO_DATA)
        val position = intent.getIntExtra(Constant.KEY_SHOW_POSITION, 0)
        selectionPagerAdapter = SectionsPagerAdapter(supportFragmentManager, list)

        container.adapter = selectionPagerAdapter
        container.addOnPageChangeListener(this)
        container.setCurrentItem(position, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        container.removeOnPageChangeListener(this)
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {

    }
}
