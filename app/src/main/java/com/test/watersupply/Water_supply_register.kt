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



class Water_supply_register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_supply_register)

        val reg_name: EditText=findViewById(R.id.edit_name)
        val reg_email: EditText=findViewById(R.id.edit_email)
        val reg_pass1: EditText=findViewById(R.id.edit_password)
        val reg_pass2: EditText=findViewById(R.id.edit_password1)
        val reg_button: Button=findViewById(R.id.edit_button)
        val reg_login:TextView=findViewById(R.id.edit_login)

        val auth = FirebaseAuth.getInstance()


        if(auth.currentUser != null){
            val intent_main = Intent(this, MainActivity::class.java)
            startActivity(intent_main)
        }

        reg_login.setOnClickListener {
            val intent_main = Intent(this, Water_supply_login::class.java)
            startActivity(intent_main)
        }


        reg_button.setOnClickListener {
          val email=reg_email.text.toString().trim()
          val name=reg_name.text.toString().trim()
          val pass1= reg_pass1.text.toString().trim()
          val pass2 = reg_pass2.text.toString().trim()

          if(TextUtils.isEmpty(email)){
              reg_email.setError("Email is required")
              return@setOnClickListener
          }

            if(TextUtils.isEmpty(name)){
                reg_name.setError("Name is required")
                return@setOnClickListener
            }

            if(TextUtils.isEmpty(pass1)){
                reg_pass1.setError("Password is required")
                return@setOnClickListener
            }

            if(pass1.length < 8){
                reg_pass1.setError("password must be >=8 character")
                return@setOnClickListener
            }

            if(TextUtils.isEmpty(pass2)){
                reg_pass2.setError("Password is required")
                return@setOnClickListener
            }

            if(TextUtils.equals(pass1,pass2)){
                auth.createUserWithEmailAndPassword(email,pass1)
                    .addOnCompleteListener {
                        if(it.isSuccessful){
                            Toast.makeText(this,"User Created",Toast.LENGTH_SHORT).show()
                            val intent_main = Intent(this, MainActivity::class.java)
                            startActivity(intent_main)
                        }
                        else{
                            Toast.makeText(this,"User Not Created",Toast.LENGTH_SHORT).show()
                        }
                    }

            }
            else{
                reg_pass1.setError("Password not matched")
                reg_pass2.setError("Password not matched")
                return@setOnClickListener

            }
        }




    }
}


/*
fun logout(){
    FirebaseAuth.getInstance().signOut()
    val intent_main = Intent(this, Water_supply_login::class.java)
    startActivity(intent_main)
    finish()
}


 */