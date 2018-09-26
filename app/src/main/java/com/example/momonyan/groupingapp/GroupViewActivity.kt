package com.example.momonyan.groupingapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Layout
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ListView

class GroupViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //ボタンの処理追加
        val backButton: Button = Button(this)
        backButton.text = "戻る"
        backButton.setOnClickListener {
            finish()
        }

        //グループ分け
        var memberString = intent.getStringExtra("String").split("\n").toMutableList()
        val groupNum = intent.getIntExtra("Num", 1)
        //余分を追加
        if (memberString.size % groupNum != 0) {
            for (i in 0 until groupNum - (memberString.size % groupNum)) {
                memberString.add(memberString.lastIndex + 1, "")
            }
        }
        //shuffle
        val shuffleStrings = memberString.shuffled()
        //表示用に追加
        var items = mutableListOf<String>()
        var listCount = 0
        var groupCount = 1
        val putGroup = shuffleStrings.size / groupNum
        for (i in 0 until shuffleStrings.size) {
            if (i % putGroup == 0) {
                items.add(listCount, "Group" + groupCount)
                listCount++
                groupCount++
            }
            items.add(listCount, "\t\t・" + shuffleStrings[i])
            listCount++
        }
        //余分を削除
        items = items.filter { it != "\t\t・" }.toMutableList()
        //表示用に追加
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items)
        val listView = ListView(this)
        listView.adapter = arrayAdapter

        //表示
        val layout:LinearLayout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.addView(listView)
        layout.addView(backButton)
        setContentView(layout)
    }
}