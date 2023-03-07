package com.codepath.wishlist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var itemsRv: RecyclerView
    private lateinit var priceEditText: EditText
    private lateinit var urlEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var button: Button
    lateinit var wishlistItems: MutableList<wishitems>

    @SuppressLint(/* ...value = */ "MissingInflatedId", "NotifyDataSetChanged")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        itemsRv = findViewById(R.id.listRv)

        wishlistItems = ArrayList()
        val adapter = ItemsAdapter(wishlistItems)
        itemsRv.adapter = adapter
        itemsRv.layoutManager = LinearLayoutManager(this)



        priceEditText = findViewById(R.id.editPrice)
        urlEditText = findViewById(R.id.editUrl)
        nameEditText = findViewById(R.id.editName)

        button = findViewById(R.id.button)

        button.setOnClickListener {

            val newItem = wishitems(priceEditText.text.toString(), nameEditText.text.toString(), urlEditText.text.toString())
            wishlistItems.add(newItem)
            adapter.notifyDataSetChanged()
        }


    }
}