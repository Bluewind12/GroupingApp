package com.example.momonyan.groupingapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView

class GroupViewActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var memberString = intent.getStringExtra("String")
        val memberStrings = memberString.split("\n")
        val groupNum = intent.getIntExtra("Num", 1)

        Log.d("入力文字",getString(R.string.inputDebug,0,memberStrings[0]))
//        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, memberStrings)
//        listView = findViewById(R.id.groupListView)
//        listView.adapter = arrayAdapter
    }
}