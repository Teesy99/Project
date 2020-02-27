package com.test.watersupply

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import java.util.*
import kotlin.random.Random


class Show_data : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data)

        var database = FirebaseDatabase.getInstance()
        val Refer = database.getReference("sensor")

        val c = Calendar.getInstance()
        val dd = c.get(Calendar.DAY_OF_MONTH)
        val mm = c.get(Calendar.MONTH)
        val yy= c.get(Calendar.YEAR)

        val h = c.get(Calendar.HOUR_OF_DAY)
        val min = c.get(Calendar.MINUTE)
        val sec = c.get(Calendar.SECOND)

        val da : String = yy.toString() + "-" + mm.toString()+ "-" + dd.toString()
        val ti : String = h.toString() + "-" + min.toString()+ "-" + sec.toString()

        val press:Int = 9
        val temp :Int= 100

        val to: String? = Refer.push().key

        val data=sensor_data(ti,da,press,temp)

        Refer.child(ti.toString()).setValue(data)

    }
}
