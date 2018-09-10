package com.example.momonyan.groupingapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
            val inputTexts = editGroupText.text.split("\n")
            for (i in 0 until inputTexts.size) {
                Log.d("入力されてる文字", getString(R.string.inputDebug, i, inputTexts[i]))
            }
        }
    }

    private fun init() {
        editGroupText = findViewById(R.id.editText)
        editNumText = findViewById(R.id.editNumText)
        selectButton = findViewById(R.id.changeButton)
    }
}
