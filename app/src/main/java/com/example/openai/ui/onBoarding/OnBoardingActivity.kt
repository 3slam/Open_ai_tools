package com.example.openai.ui.onBoarding

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.openai.MainActivity
import com.example.openai.R
import com.example.openai.databinding.ActivityOnBoardingBinding
import com.example.openai.ui.base.BaseActivity
import com.example.openai.utilites.IS_THE_FIRST_TIME
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingActivity : BaseActivity<ActivityOnBoardingBinding>() {

    override val layoutActivityId: Int = R.layout.activity_on_boarding

    @Inject
    lateinit var sharedPreferences :SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       supportActionBar?.hide()

       val openAppFirstTime = sharedPreferences.getBoolean(IS_THE_FIRST_TIME,false)

        if (openAppFirstTime){
           startActivity(Intent(this, MainActivity::class.java))
        }

        val onBoardingScreens = listOf(R.layout.on_boarding_one_fragment, R.layout.on_boarding_two_fragment)

        binding.viewPager.adapter = OnBoardingPagerAdapter(onBoardingScreens)

        binding.dotsIndicator.attachTo(binding.viewPager)

        binding.getStart.setOnClickListener {
            sharedPreferences.edit().putBoolean(IS_THE_FIRST_TIME, true).apply()
            startActivity(Intent(this, MainActivity::class.java))
        }


    }

}