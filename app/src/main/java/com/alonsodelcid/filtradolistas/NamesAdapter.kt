package com.alonsodelcid.filtradolistas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_name.view.*

class NamesAdapter: RecyclerView.Adapter<NamesAdapter.NamesViewHolder>() {
    private var names: List<String> = emptyList()

    fun setNamesList(names: List<String>){
        this.names = names
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesViewHolder {
        return NamesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_name, parent, false))
    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(holder: NamesViewHolder, position: Int) {
        holder.itemView.idTextView.text = position.toString()
        holder.itemView.nameTextView.text = names[position]
    }

    class NamesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}