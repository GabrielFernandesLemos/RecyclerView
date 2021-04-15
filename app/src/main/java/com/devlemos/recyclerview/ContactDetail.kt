package com.devlemos.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.devlemos.recyclerview.model.Contact

class ContactDetail : AppCompatActivity() {

    private  var contact : Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        getExtras()
        bindViews()
        initToolBar()
    }

    private fun initToolBar(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun getExtras(){
        contact = intent.getParcelableExtra(EXTRA_CONTACT)
    }

    private fun bindViews(){
        findViewById<TextView>(R.id.txtDatailName).text = contact?.name
        findViewById<TextView>(R.id.txtDetailNumber).text = contact?.number
    }

    companion object{
        const val EXTRA_CONTACT: String = "EXTRA_CONTACT"
    }
}