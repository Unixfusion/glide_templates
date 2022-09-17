package com.unixfusion.glideloadcacheimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.bumptech.glide.Glide
import com.unixfusion.glideloadcacheimages.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var imageUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageUrl = savedInstanceState?.getString(KEY_IMAGE_URL) ?:
        imageList[Random.nextInt(imageList.size)]

        Glide.with(this)
            .load(imageUrl)
            .into(binding.ivMain)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString(KEY_IMAGE_URL, imageUrl)
    }

    companion object{
        const val KEY_IMAGE_URL = "KEY_IMAGE_URL"
        val imageList = listOf(
            "https://unsplash.com/photos/ff11JzQk690",
            "https://unsplash.com/photos/UJ5neyuKtjg",
            "https://unsplash.com/photos/n1L3kBf1CWQ",
            "https://unsplash.com/photos/I2MvIfi7JcY",
            "https://unsplash.com/photos/75lAzi1jn3w",
            "https://unsplash.com/photos/tsUNxs1Owoc",
            "https://unsplash.com/photos/n0bdvrBqHlQ",
            "https://unsplash.com/photos/sUbOjcqu5KE",


        )
    }
}