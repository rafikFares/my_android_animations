package com.example.myanimations.overided_layouts

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.viewpager.widget.ViewPager

class MyViewPager @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr) , ViewPager.OnPageChangeListener{

    private val numberOfPages = 3

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        progress = (position + positionOffset) / (numberOfPages - 1)    }

    override fun onPageSelected(position: Int) {
    }

}