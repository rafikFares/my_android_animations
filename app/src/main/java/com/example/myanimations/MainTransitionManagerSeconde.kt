package com.example.myanimations

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.animation.LinearInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.transition_manager_frame2.*

class MainTransitionManagerSeconde : AppCompatActivity() {

    private val constraintSet1 = ConstraintSet()
    private val constraintSet2 = ConstraintSet()

    private var isOffscreen = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transition_manager_frame2)


        switch1.setOnCheckedChangeListener { _, isChecked ->
            switch1.text = if (isChecked) "round_trip" else "one_way"
        }

        constraintSet1.clone(constraintLayout) //1
        constraintSet2.clone(this, R.layout.transition_manager_frame3) //2

        departButton.setOnClickListener {
            transitionOfKeyFrameScreen()
            //rocketAnimation()
        }
        /**
         *
        1 This pulls the layout information from the initial layout into one of the constraint sets, constraintSet1.
        Since you added an ID to the ConstraintLayout earlier, you can refer to it directly from code now.

        2 This pulls the layout information from the final layout into constraintSet2.
        Since you are creating a ConstraintSet and you never actually inflate the second layout file,
        you avoid the overhead and performance hit of dealing with a second layout.

         */

        /**
         *
        Animating the Bounds of a View

        Not only can you change the position of elements onscreen by affecting their constraints, but you can also change their size.

        Open keyframe1.xml and select the galaxy icon, whose ID is galaxyIcon. Change the layout_height property from 90dp to 10dp.

        Note: In activity_main.xml, the height is still set to 90dp.
         */
    }

    override fun onEnterAnimationComplete() { //1
        super.onEnterAnimationComplete()

        constraintSet2.clone(this, R.layout.transition_manager_frame2) //2

        //apply the transition
        val transition = AutoTransition() //3
        transition.duration = 1000 //4
        TransitionManager.beginDelayedTransition(constraintLayout, transition) //5

        constraintSet2.applyTo(constraintLayout) //6

        /**
         *
        1 Activities can’t draw anything while the view is animating.
        onEnterAnimationComplete() is the point in the app life cycle
        where the view animation has completed and it’s safe to call on drawing code.

        2 This pulls the layout information from your final layout into constraintSet2.

        3 This creates a custom transition. In this case, you are using a built-in transition,
        AutoTransition(), which first fades out disappearing targets,
        then moves and resizes existing targets, and finally fades in appearing targets.

        4 This sets a duration of 1,000 milliseconds for the animation, so that it’s slow enough to be seen.

        5 This calls Transition Manager’s beingDelayedTransition function,
        but this time you also supply your custom transition.

        6 This applies the new ConstraintSet to the currently-displayed ConstraintLayout.

         */
    }

    fun transitionOfKeyFrameScreen() {
        //3
        //apply the transition
        TransitionManager.beginDelayedTransition(constraintLayout) //4
        val constraint = if (!isOffscreen) constraintSet1 else constraintSet2
        isOffscreen = !isOffscreen
        constraint.applyTo(constraintLayout) //5

        /**
         *
        3 This adds the animation in the listener for the button, for now,
        so that you can trigger the animation whenever it’s toggled.

        4 This calls Transition Manager’s beingDelayedTransition function.

        5 This applies the new ConstraintSet to the currently displayed ConstraintLayout.
         */
    }

    fun rocketAnimation() {
        //1
        val layoutParams = rocketIcon.layoutParams as ConstraintLayout.LayoutParams
        val startAngle = layoutParams.circleAngle
        val endAngle = startAngle + (if (switch1.isChecked) 360 else 180)

        //2
        val anim = ValueAnimator.ofFloat(startAngle, endAngle)
        anim.addUpdateListener { valueAnimator ->

            //3
            val animatedValue = valueAnimator.animatedValue as Float
            val layoutParams = rocketIcon.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.circleAngle = animatedValue
            rocketIcon.layoutParams = layoutParams

            //4
            rocketIcon.rotation = (animatedValue % 360 - 270)
        }
        //5
        anim.duration = if (switch1.isChecked) 2000 else 1000

        //6
        anim.interpolator = LinearInterpolator()
        anim.start()

        /**
         *
        1 Set startAngle to the current angle of the rocket before animation start.
        Depending on One Way / Round Trip switch, endAngle is either 180 or 360 degree in addition to startAngle value.

        2 ValueAnimator class provides a simple timing engine for running animations between two values.
        Here you provide startAngle and endAngle to create the instance of ValueAnimator.

        3 Inside update listener of ValueAnimator instance,
        obtain the animated value and assign it to the rocket’s circleAngle in layoutParams.

        4 Rotate the rocket with animated value. This will make the rocket fly in more natural direction.

        5 This is quite straightforward. One way animation takes 1 second,
        while round trip animation takes 2 seconds.

        6 Choose LinearInterpolator to make sure passengers have pleasant flight.
        You can try AnticipateOvershootInterpolator to see what will happen :] Last but not least, start the animation!

         */
    }

}