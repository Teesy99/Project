package com.test.watersupply

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

public class data(){


}


class Show_data : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data)

        val database = FirebaseFirestore.getInstance()
        var strUser: String = intent.getStringExtra("Username")

        val tbox: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button1)
        val listview : ListView = findViewById(R.id.listview1)
        // val grid_time : ListView = findViewById(R.id.time1)



        tbox.text = "Data of " + strUser


        //val Refer = database.getReference("sensor")

        button.setOnClickListener {
            //upload()
            val intent1= Intent(this, Water_supply_register::class.java)
            startActivity(intent1)
        }




        database.collection(strUser)
            .addSnapshotListener{ value, e ->
                if (e != null) {
                    Log.w("TAG", "Listen failed.", e)
                    return@addSnapshotListener
                }

                val cities = ArrayList<String>()

                for (doc in value!!) {
                    doc.getString("da")?.let {
                        cities.add(it)
                    }
                }

                val time1 = ArrayList<String>()
                for (doc in value!!) {
                    doc.getString("ti")?.let {
                        time1.add(it)
                    }
                }

                val pres = ArrayList<String>()
                for (doc in value!!) {
                    doc.getString("press")?.let {
                        pres.add(it)
                    }

                }

                //val array = arrayOfNulls<String>(cities.size)

                //val arr:Array<String> = cities.toArray(array)
               // val arr1 =Arrays.asList(*arr)

                val test =ArrayList<String>()
                for (i in 0..(cities.size-1)){
                    test.add( cities.get(i) +"         " +time1.get(i)+ "                   "+ pres.get(i) )

                }



                //val gridview = findViewById<GridView>(R.id.gridView)




               // val adapter = data_adaptor(this, R.layout.data,)
                //gridview.adapter=adapter
                //println(gridview)

                var adapt= ArrayAdapter(this,android.R.layout.simple_list_item_1,test)
                listview.adapter=adapt
                //gridview.adapter(time1)
            }

    }




    fun upload() {
        val database = FirebaseFirestore.getInstance()
        var strUser: String = intent.getStringExtra("Username")

        val c = Calendar.getInstance()
        val dd = c.get(Calendar.DAY_OF_MONTH)
        val mm = c.get(Calendar.MONTH) + 1
        val yy = c.get(Calendar.YEAR)

        val hh = c.get(Calendar.HOUR_OF_DAY)
        val min1 = c.get(Calendar.MINUTE)
        val sec1 = c.get(Calendar.SECOND)
        val p: String = "/"
        val t: String = ":"
        var m: String = if (mm < 10) {
            "0" + mm.toString()
        } else {
            mm.toString()
        }

        var d: String = if (dd < 10) {
            "0" + dd.toString()
        } else {
            dd.toString()
        }
        var h: String = if (hh < 10) {
            "0" + hh.toString()
        } else {
            hh.toString()
        }
        var min: String = if (min1 < 10) {
            "0" + min1.toString()
        } else {
            min1.toString()
        }

        var sec: String = if (sec1 < 10) {
            "0" + sec1.toString()
        } else {
            sec1.toString()
        }





        val da: String = yy.toString() + p + m + p + d

        val ti: String = h + t + min + t + sec

        val pr: Int = Random.nextInt() % 100

        var press: String= if (pr > 0) {
            pr.toString()
        }else{
            (-pr).toString()
        }

        val temp: Int = Random.nextInt() % 1000


        val city = hashMapOf(
            "ti" to ti,
            "da" to da,
            "press" to press,
            "temp" to temp
        )


        database.collection(strUser).add(city)


    }

    fun show() {
        val db: FirebaseFirestore = FirebaseFirestore.getInstance()
        val ref = db.collection("S3")

    }


}




