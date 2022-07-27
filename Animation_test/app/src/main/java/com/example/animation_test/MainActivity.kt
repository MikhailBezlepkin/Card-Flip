package com.example.animation_test

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.animation.doOnEnd
import com.example.animation_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()  {
    private lateinit var binding: ActivityMainBinding
    lateinit var front_anim: AnimatorSet
    lateinit var back_anim: AnimatorSet
    var isFront = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        front_anim = AnimatorInflater.loadAnimator(applicationContext, R.animator.front_animator) as AnimatorSet
        back_anim = AnimatorInflater.loadAnimator(applicationContext, R.animator.back_animator) as AnimatorSet



        binding.ben.setOnClickListener {
            if (isFront){
                front_anim.setTarget(binding.cvImageTaroCards)
                front_anim.start()
                front_anim.doOnEnd {  binding.taroCardsIv.setImageResource(R.drawable.taro_card_sample)
                    back_anim.setTarget(binding.cvImageTaroCards)
                    back_anim.start() }
                isFront = false


            }
            else{


                isFront = true
            }
        }

    }


}