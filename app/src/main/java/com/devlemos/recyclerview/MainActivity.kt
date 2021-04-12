package com.devlemos.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devlemos.recyclerview.adapter.ContactAdapter
import com.devlemos.recyclerview.model.Contact

class MainActivity : AppCompatActivity() {

    private val recyclerview : RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.recyclerview)
    }
    private val adapter = ContactAdapter()
    var viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
        setupList()
    }

    private fun setupList() {
        viewModel.updateList(adapter)
    }

    private fun bindViews(){
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)
    }
}
