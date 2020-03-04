package com.test.watersupply

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Logo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)

        val dice1 : ImageView = findViewById(R.id.imageView2)
        dice1.setImageResource(R.drawable.logo)

       // Thread.sleep(5000)
        val intent_main = Intent(this, Water_supply_login::class.java)
        startActivity(intent_main)


    }
}
