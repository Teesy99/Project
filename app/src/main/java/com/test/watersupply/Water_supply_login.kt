package com.test.watersupply

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Water_supply_login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_supply_login)

        val email : EditText = findViewById(R.id.login_email)
        val pass  : EditText = findViewById(R.id.login_password )
        val forgotpass : TextView = findViewById(R.id.login_forgot)
        val newuser : TextView = findViewById(R.id.login_registration)
        val btnlogin :Button = findViewById(R.id.login_button)

        val auth = FirebaseAuth.getInstance()



        if(auth.currentUser != null){
            val intent_main = Intent(this, MainActivity::class.java)
            startActivity(intent_main)
        }

        newuser.setOnClickListener(){
            val intent_main = Intent(this, Water_supply_register::class.java)
            startActivity(intent_main)
        }


        btnlogin.setOnClickListener {


            val trim_mail = email.text.toString().trim()
            val trim_pass = pass.text.toString().trim()


            if (TextUtils.isEmpty(trim_mail)) {
                email.setError("Email is required")
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(trim_pass)) {
                pass.setError("Password is required")
                return@setOnClickListener
            }

            if (trim_mail.length < 8) {
                email.setError("password must be >=8 character")
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(trim_mail, trim_pass)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Logged in Successfull", Toast.LENGTH_SHORT).show()
                        val intent_main = Intent(this, MainActivity::class.java)
                        startActivity(intent_main)
                    } else {
                        Toast.makeText(this, "Email or Password is incorrect", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

        }

    }
}
