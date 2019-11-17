package com.example.myanimations

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.animation_drawable_main.*


class MainAnimationDrawable : AppCompatActivity() {

    private lateinit var rocketAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animation_drawable_main)

        imageView2.apply {
            setBackgroundResource(R.drawable.animation_drawable_gif)
            rocketAnimation = background as AnimationDrawable
        }

    }

    override fun onStart() {
        super.onStart()
        rocketAnimation.start() // this really need to be here
    }
}
