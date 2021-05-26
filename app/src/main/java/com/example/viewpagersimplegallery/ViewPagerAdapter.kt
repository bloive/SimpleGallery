package com.example.viewpagersimplegallery

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter(private val images: MutableList<Int>, private val handler: ClickHandler) : PagerAdapter() {

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as View
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeViewAt(position)
        Log.d("click", " remove")
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context).inflate(R.layout.image_layout, container, false)
        view.findViewById<ImageView>(R.id.imageView).setImageResource(images[position])
        container.addView(view, position)
        view.findViewById<ImageView>(R.id.imageView).setOnClickListener {
            Log.d("click", " zoom")
            when (position) {
                0 -> handler.handleClick(CustomPagerEnum.IMAGE_ONE)
                1 -> handler.handleClick(CustomPagerEnum.IMAGE_TWO)
                2 -> handler.handleClick(CustomPagerEnum.IMAGE_THREE)
            }
        }
        return view
    }
}