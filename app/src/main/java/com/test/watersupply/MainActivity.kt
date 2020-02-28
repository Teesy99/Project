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
        val b2 : Button = findViewById(R.id.B2)

        val intent= Intent(this, Show_data::class.java)

        b1.setOnClickListener {
            intent.putExtra("Username", "S1")
            startActivity(intent)
        }

        b2.setOnClickListener {
            intent.putExtra("Username", "S2")
            startActivity(intent)
        }

    }
}
