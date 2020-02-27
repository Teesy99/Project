package com.test.watersupply

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val dice_img : ImageView = findViewById(R.id.imageView)
        dice_img.setImageResource(R.drawable.water_distribution_pic1)

        val b1 : Button = findViewById(R.id.B1)
        b1.setOnClickListener {
            val intent= Intent(this, Show_data::class.java)
            intent.putExtra("Username", "Name")
            startActivity(intent)
        }

    }
}
