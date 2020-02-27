package com.test.watersupply

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import java.time.LocalDateTime
import java.util.*
import kotlin.random.Random


class Show_data : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data)

        var strUser: String = intent.getStringExtra("Username")

        val database = FirebaseFirestore.getInstance()
        //val Refer = database.getReference("sensor")

        val c = Calendar.getInstance()
        val dd = c.get(Calendar.DAY_OF_MONTH)
        val mm = c.get(Calendar.MONTH)+1
        val yy= c.get(Calendar.YEAR)

        val h = c.get(Calendar.HOUR_OF_DAY)
        val min = c.get(Calendar.MINUTE)
        val sec = c.get(Calendar.SECOND)
        val  p :String="/"
        val t : String=":"
        var m : String= if(mm < 10) {
             "0"+ mm.toString()
        }
        else {
              mm.toString()
        }

        val da : String =  yy.toString()+ p + m + p + dd.toString()

        val ti : String = h.toString() + t + min.toString()+ t + sec.toString()

        val press: Int=9
        val temp : Int= Random.nextInt()%1000


        val city = hashMapOf(
            "ti" to ti,
            "da" to da,
            "press" to press,
            "temp" to temp
        )

        database.collection("sensor")
            .add(city)


        //val to: String? = Refer.push().key

       // val data=sensor_data(ti,da,press,temp)

        //Refer.child(to.toString()).setValue(data)

    }
}

