package com.example.viewpagersimplegallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagersimplegallery.databinding.FragmentImageBinding

class ImageFragment(private val enum: CustomPagerEnum) : Fragment() {

    private lateinit var binding: FragmentImageBinding


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageBinding.inflate(inflater, container, false)
        init(enum)
        return binding.root
    }

    private fun init(enum: CustomPagerEnum) {
            binding.imageView2.setImageResource(enum.image)
    }
}