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
        var memberString = intent.getStringExtra("String")
        val shuffleStrings = memberString.split("\n").shuffled()
        val groupNum = intent.getIntExtra("Num", 1)

        val items = mutableListOf<String>()
        for (i in 0 until shuffleStrings.size) {
            items.add(i, shuffleStrings[i])
        }
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items)
//        groupView = findViewById(R.id.groupListView)
//        groupView.adapter = arrayAdapter
        val listView = ListView(this)
        listView.adapter = arrayAdapter
        setContentView(listView)
    }
}