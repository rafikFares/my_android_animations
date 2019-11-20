package com.example.myanimations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainOverridedMotionLayoutWithCoordinator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animation_coordinator_with_edited_motion_layout)
    }
}