package com.example.viewpagersimplegallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewpagersimplegallery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ClickHandler {

    private lateinit var binding: ActivityMainBinding
    private var imageList: MutableList<Int> = mutableListOf(R.mipmap.image1, R.mipmap.image2, R.mipmap.image3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPagerAdapter(imageList, this)
    }

    override fun handleClick(enum: CustomPagerEnum) {
        startImageFragment(enum)
    }

    private fun startImageFragment(enum: CustomPagerEnum) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.addToBackStack(null)
        val frag = ImageFragment(enum)
        transaction.add(R.id.fragment, frag).commit()
    }
}