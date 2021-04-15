package com.devlemos.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devlemos.recyclerview.ContactDetail.Companion.EXTRA_CONTACT
import com.devlemos.recyclerview.adapter.ContactAdapter
import com.devlemos.recyclerview.model.Contact

class MainActivity : AppCompatActivity(), ClickItemContactListener {

    private val recyclerview : RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.recyclerview)
    }
    private val adapter = ContactAdapter(this)
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

    override fun clickItemContact(contact: Contact) {
        val intent = Intent(this, ContactDetail::class.java)
        intent.putExtra(EXTRA_CONTACT, contact)
        startActivity(intent)
    }
}
