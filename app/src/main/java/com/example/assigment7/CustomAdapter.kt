package com.example.assigment7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assigment7.patterns.Data
import com.squareup.picasso.Picasso

class CustomAdapter(private val mList: List<Data>,val userClick: ((id:String) -> Unit)) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]

        Picasso.with(holder.imageView.context).load(itemsViewModel.avatar).into(holder.imageView)
        holder.textView.text = itemsViewModel.firstName
        holder.imageView.setOnClickListener {
            userClick(itemsViewModel.id.toString())
        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image)
        val textView: TextView = itemView.findViewById(R.id.name)
    }
}
