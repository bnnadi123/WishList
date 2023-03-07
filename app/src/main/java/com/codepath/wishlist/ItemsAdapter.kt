package com.codepath.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(private val wishList: List<wishitems>):RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameTextView: TextView
        val priceTextView: TextView
        val urlTextView: TextView


        init {
            nameTextView = itemView.findViewById(R.id.Name)
            priceTextView = itemView.findViewById(R.id.Price)
            urlTextView = itemView.findViewById(R.id.url)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_list, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val items = wishList.get(position)
        // Set item views based on views and data model
        holder.nameTextView.text = items.name
        holder.priceTextView.text = items.price
        holder.urlTextView.text = items.url
    }

    override fun getItemCount(): Int {
        return wishList.size
    }
}

