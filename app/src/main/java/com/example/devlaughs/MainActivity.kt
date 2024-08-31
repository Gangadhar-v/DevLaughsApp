package com.example.devlaughs

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val tv = findViewById<TextView>(R.id.textView)
//
//        val retrofitService = RetrofitInstance.retrofitService
//
//        val response = retrofitService.getJokes()
//
//        response.enqueue(object:Callback<JokeResponse>{
//            override fun onResponse(call: Call<JokeResponse>, response: Response<JokeResponse>) {
//
//                val data = response.body()
//                tv.text = data?.jokes.toString()
//            }
//
//            override fun onFailure(call: Call<JokeResponse>, t: Throwable) {
//                tv.text = t.message
//            }
//
//        })
    }
}