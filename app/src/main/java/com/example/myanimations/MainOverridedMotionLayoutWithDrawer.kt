package com.example.myanimations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainOverridedMotionLayoutWithDrawer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_layout_with_edited_motion_layout)
    }
}