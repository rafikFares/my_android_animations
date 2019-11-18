package com.example.myanimations

import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import kotlinx.android.synthetic.main.animation_vector_drawable_main.*

class MainAnimationVectorDrawable : AppCompatActivity() {

    private var rocketAnimation: AnimatedVectorDrawableCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animation_vector_drawable_main)

        rocketAnimation = AnimatedVectorDrawableCompat.create(this, R.drawable.animator_vector_drawable)

        imageView4.apply {
            setImageDrawable(rocketAnimation)
        }
    }

    override fun onStart() {
        super.onStart()
         rocketAnimation?.start() // this really need to be here
    }

}
