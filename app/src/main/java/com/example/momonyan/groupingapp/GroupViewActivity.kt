package com.example.momonyan.groupingapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.group_view.*

class GroupViewActivity : AppCompatActivity() {
//    private lateinit var groupView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.group_view)
        var memberString = intent.getStringExtra("String")
        val memberStrings = memberString.split("\n")
        val groupNum = intent.getIntExtra("Num", 1)

        Log.d("入力文字",getString(R.string.inputDebug,0,memberStrings[0]))
        val items = mutableListOf<String>()
        for(i in 0 until memberStrings.size) {
            items.add(i,memberStrings[i])
        }
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items)
//        groupView = findViewById(R.id.groupListView)
//        groupView.adapter = arrayAdapter
    }
}