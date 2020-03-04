package com.test.watersupply

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val dice : ImageView = findViewById(R.id.imageView)
        dice.setImageResource(R.drawable.water_channel)

        val b1 : Button = findViewById(R.id.B1)
        val b2 : Button = findViewById(R.id.B2)
        val b3 : Button = findViewById(R.id.B3)
        val b4 : Button = findViewById(R.id.B4)
        val b5 : Button = findViewById(R.id.B5)
        val b6 : Button = findViewById(R.id.B6)
        val b: Button = findViewById(R.id.log_out)

        val intent= Intent(this, Show_data::class.java)

        b1.setOnClickListener {
            intent.putExtra("Username", "S1")
            startActivity(intent)
        }

        b2.setOnClickListener {
            intent.putExtra("Username", "S2")
            startActivity(intent)
        }

        b3.setOnClickListener {
            intent.putExtra("Username", "S3")
            startActivity(intent)
        }

        b4.setOnClickListener {
            intent.putExtra("Username", "S4")
            startActivity(intent)
        }

        b5.setOnClickListener {
            intent.putExtra("Username", "S5")
            startActivity(intent)
        }

        b6.setOnClickListener {
            intent.putExtra("Username", "S6")
            startActivity(intent)
        }

        b.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val intent_main = Intent(this, Water_supply_login::class.java)
            startActivity(intent_main)
            finish()
        }

    }
}
