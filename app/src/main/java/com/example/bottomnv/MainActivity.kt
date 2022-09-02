package com.example.bottomnv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home -> replaceFragment(Home())
                R.id.products -> replaceFragment(Products())
                R.id.gift -> replaceFragment(Gifts())
                R.id.you -> replaceFragment(You())

                else -> {

                }


            }
                true
        }
    }

    private  fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction =  fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}