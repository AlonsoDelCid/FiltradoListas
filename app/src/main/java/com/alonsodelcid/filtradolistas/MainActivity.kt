package com.alonsodelcid.filtradolistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val names = resources.getStringArray(R.array.names)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NamesAdapter()

        (recyclerView.adapter as NamesAdapter).setNamesList(names.asList())

        filterEditText.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val list = names.asList().filter { it.toString().toLowerCase().contains(s.toString().toLowerCase()) }
                (recyclerView.adapter as NamesAdapter).setNamesList(list)
            }

        })
    }
}