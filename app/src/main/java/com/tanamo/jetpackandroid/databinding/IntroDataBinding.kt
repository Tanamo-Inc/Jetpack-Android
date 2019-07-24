package com.tanamo.jetpackandroid.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.tanamo.jetpackandroid.R

/***
 *DataBinding Code is shorter, easier to read, and easier to maintain than code that uses findByView().
 *Data and views are clearly separated
 *The Android system only traverses the view hierarchy once to get each view, and it happens during app startup,
 *not at runtime when the user is interacting with the app.
 *Every time findViewById() is called, it traverses the view hierarchy.
 *findViewById() runs on the main or UI thread.
 *These calls can slow down the user interface.
 *Your app is less likely to crash.
 **/

class IntroDataBinding : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: DatabindingIntroBinding = DataBindingUtil.setContentView(this, R.layout.databinding_intro)

        //Use data binding to display data

        val model = UserModel("Tony", "Male", "Ghana", 233)

        binding.modd = model


    }
}