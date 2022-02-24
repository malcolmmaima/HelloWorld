package com.myapp.helloworld

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.myapp.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var myImage: Drawable? = null

    /** Leak
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textview.text = "Hello World!"

        if(myImage == null) {
            myImage = resources.getDrawable(R.drawable.ic_launcher_background)
        }
        binding.textview.setBackgroundDrawable(myImage)
    }
    **/

    /** No Leak
     *
     **/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textview.text = "Hello World!"

        if(myImage == null) {
            myImage = getApplicationContext().getResources().getDrawable(R.drawable.ic_launcher_background, applicationContext.resources.newTheme())
        }
        binding.imageView.setImageDrawable(myImage)
    }
}