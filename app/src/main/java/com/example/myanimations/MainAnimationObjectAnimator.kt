package com.example.myanimations

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.animation_object_animator.*

class MainAnimationObjectAnimator : AppCompatActivity() {

    private lateinit var objectAnimator : ObjectAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animation_object_animator)

        objectAnimator = AnimatorInflater.loadAnimator(this, R.animator.object_animator) as ObjectAnimator

    }

    override fun onStart() {
        super.onStart()
        objectAnimator.target = imageView3
        objectAnimator.start()
    }
}
