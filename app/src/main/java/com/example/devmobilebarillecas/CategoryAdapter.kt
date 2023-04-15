package com.example.devmobilebarillecas

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private val categoryItems: List<CategoryItem>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryButton: Button = itemView.findViewById(R.id.categoryButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categoryItem = categoryItems[position]
        holder.categoryButton.text = categoryItem.title

        holder.categoryButton.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ProductsActivity::class.java)
            intent.putExtra("products_url", categoryItem.products_url)
            intent.putExtra("title", categoryItem.title)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return categoryItems.size
    }
}