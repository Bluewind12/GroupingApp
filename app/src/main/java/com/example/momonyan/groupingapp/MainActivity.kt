package com.example.momonyan.groupingapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var editGroupText: EditText
    private lateinit var editNumText: EditText
    private lateinit var selectButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        selectButton.setOnClickListener {
            val intent = Intent(this, GroupViewActivity::class.java)
            intent.putExtra("String", editGroupText.text.toString())
            intent.putExtra("Num", Integer.parseInt(editNumText.text.toString()))
            startActivity(intent)

        }
    }

    private fun init() {
        editGroupText = findViewById(R.id.editText)
        editNumText = findViewById(R.id.editNumText)
        selectButton = findViewById(R.id.changeButton)
    }
}
