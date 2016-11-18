package tech.thdev.bottomsheet

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.util.TypedValue
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        // rl_bottom_sheet을 BottomSheetBehavior에 등록한다
        val bottomSheetBehavior = BottomSheetBehavior.from(rl_bottom_sheet)
        // 높이 설정
        bottomSheetBehavior.peekHeight = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 200f, resources.displayMetrics).toInt()

        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // Slide ...
                // 1이면 완전 펼쳐진 상태
                // 0이면 peekHeight인 상태
                // -1이면 숨김 상태
                Log.i("TAG", "slideOffset $slideOffset")
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                Log.d("TAG", "newState $newState")
            }
        })

        btn_show.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }
        btn_hide.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }
    }
}
