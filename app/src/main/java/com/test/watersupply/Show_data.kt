package com.test.watersupply

import android.app.ProgressDialog.show
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import org.w3c.dom.Text
import java.time.LocalDateTime
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
        val button: Button = findViewById(R.id.button)
        val gridview : GridView = findViewById(R.id.gridview)
        // val grid_time : ListView = findViewById(R.id.time1)



        tbox.text = "Data of " + strUser


        //val Refer = database.getReference("sensor")

        button.setOnClickListener {
            upload()
        }




        database.collection(strUser)
            .addSnapshotListener { value, e ->
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

                //val gridview = findViewById<GridView>(R.id.gridView)


                val array = arrayOfNulls<String>(cities.size)

                val arr:Array<String> = cities.toArray(array)

                val adapter = data_adaptor(this, R.layout.data,cities)
                gridview.adapter = adapter





            }

    }




    fun upload() {
        val database = FirebaseFirestore.getInstance()
        var strUser: String = intent.getStringExtra("Username")

        val c = Calendar.getInstance()
        val dd = c.get(Calendar.DAY_OF_MONTH)
        val mm = c.get(Calendar.MONTH) + 1
        val yy = c.get(Calendar.YEAR)

        val h = c.get(Calendar.HOUR_OF_DAY)
        val min = c.get(Calendar.MINUTE)
        val sec = c.get(Calendar.SECOND)
        val p: String = "/"
        val t: String = ":"
        var m: String = if (mm < 10) {
            "0" + mm.toString()
        } else {
            mm.toString()
        }

        val da: String = yy.toString() + p + m + p + dd.toString()

        val ti: String = h.toString() + t + min.toString() + t + sec.toString()

        val press: Int = 9
        val temp: Int = Random.nextInt() % 1000


        val city = hashMapOf(
            "ti" to ti,
            "da" to da,
            "press" to press,
            "temp" to temp
        )


        database.collection(strUser)
            .add(city)


    }

    fun show() {
        val db: FirebaseFirestore = FirebaseFirestore.getInstance()
        val ref = db.collection("S3")
        ref.get()
    }

}


