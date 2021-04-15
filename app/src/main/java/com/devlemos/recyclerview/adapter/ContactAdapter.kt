package com.devlemos.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devlemos.recyclerview.ClickItemContactListener
import com.devlemos.recyclerview.R
import com.devlemos.recyclerview.model.Contact

class ContactAdapter(var listener : ClickItemContactListener) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private val list: MutableList<Contact> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_item, parent, false)
        return ContactViewHolder(view, list, listener)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun updateList(list : List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class ContactViewHolder(itemView: View, var list: List<Contact>, var listener: ClickItemContactListener) : RecyclerView.ViewHolder(itemView) {
        private val txtName: TextView = itemView.findViewById(R.id.txtName)
        private val txtNumber: TextView = itemView.findViewById(R.id.txtNumber)

        init {
            itemView.setOnClickListener {
                listener.clickItemContact(list[adapterPosition])
            }
        }

        fun bind(contact: Contact) {
            txtName.text = contact.name
            txtNumber.text = contact.number
        }
    }
}
