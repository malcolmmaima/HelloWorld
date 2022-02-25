package com.myapp.helloworld

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.SystemClock
import android.os.SystemClock.currentThreadTimeMillis
import androidx.appcompat.app.AppCompatActivity
import com.myapp.helloworld.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var test: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            startAsyncWork()
        }
    }

    private fun startAsyncWork() {
        test++
        if (test < 10) {
            Thread(Runnable {
                SystemClock.sleep(3000)
                runOnUiThread {
                    binding.btn.text = "Thread: $test"
                    startAsyncWork()
                }
            }).start()
        } else {
            Thread.currentThread().interrupt()
            binding.btn.text = "Threads stopped at: $test"
            test = 0
        }
    }
}