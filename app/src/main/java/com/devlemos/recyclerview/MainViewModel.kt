package com.devlemos.recyclerview

import androidx.lifecycle.ViewModel
import com.devlemos.recyclerview.adapter.ContactAdapter
import com.devlemos.recyclerview.model.Contact

class MainViewModel : ViewModel() {
    fun updateList(adapter: ContactAdapter) {
        adapter.updateList(
            arrayListOf(
                Contact(
                    "Gabriel",
                    "(11)123456789"
                ),
                Contact(
                    "Fernanda",
                    "(11)542687733"
                ),
                Contact(
                    "Paulo",
                    "(11)3982473924"
                ),
                Contact(
                    "Pedro",
                    "(11)3274683274"
                ),
                Contact(
                    "Carlos",
                    "(11)3278467293"
                ),
                Contact(
                    "Maria",
                    "(11)123456789"
                ),
            )
        )
    }
}