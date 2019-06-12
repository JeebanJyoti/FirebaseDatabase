package com.example.iteradmin.firebasedatabase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var database:FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database= FirebaseDatabase.getInstance()
        val name=findViewById<EditText>(R.id.name)
        val college=findViewById<EditText>(R.id.college)
        val branch=findViewById<EditText>(R.id.branch)
        val s=findViewById<Button>(R.id.save)

        s.setOnClickListener{
            val name:String=name.text.toString()
            val college:String=college.text.toString()
            val branch:String=branch.text.toString()
            val ref:DatabaseReference=database.getReference("users").child("jeeban")
            ref.child("name").setValue(name)
            ref.child("college").setValue(college)
            ref.child("branch").setValue(branch)
        }
    }
}
