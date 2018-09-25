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
        var memberString = intent.getStringExtra("String").split("\n").toMutableList()
        val groupNum = intent.getIntExtra("Num", 1)
        if (memberString.size % groupNum != 0) {
            for (i in 0 until groupNum - (memberString.size % groupNum)) {
                memberString.add(memberString.lastIndex + 1, "")
            }
        }
        val shuffleStrings = memberString.shuffled()

        val items = mutableListOf<String>()
        var listCount = 0
        var groupCount = 1
        val putGroup = shuffleStrings.size / groupNum
        for (i in 0 until shuffleStrings.size) {
            if (i % putGroup == 0) {
                items.add(listCount, "Group" + groupCount)
                listCount++
                groupCount++
            }
            items.add(listCount, shuffleStrings[i])
            listCount++
        }
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items)
//        groupView = findViewById(R.id.groupListView)
//        groupView.adapter = arrayAdapter
        val listView = ListView(this)
        listView.adapter = arrayAdapter
        setContentView(listView)
    }
}