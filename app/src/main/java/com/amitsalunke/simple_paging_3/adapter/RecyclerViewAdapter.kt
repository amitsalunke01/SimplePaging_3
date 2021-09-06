package com.amitsalunke.simple_paging_3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.amitsalunke.simple_paging_3.R
import com.amitsalunke.simple_paging_3.data.CharacterData
import com.amitsalunke.simple_paging_3.data.Info
import com.bumptech.glide.Glide

class RecyclerViewAdapter : PagingDataAdapter<CharacterData, RecyclerViewAdapter.MyViewHolder>(DiffUtilCallBack1()) {
    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        return MyViewHolder(inflater)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvDescription: TextView = view.findViewById(R.id.tvDescription)
        fun bind(data: CharacterData) {
            tvName.text = data.name
            tvDescription.text = data.species
            Glide.with(imageView)
                    .load(data.image)
                    .circleCrop()
                    .into(imageView)
        }
    }

    class DiffUtilCallBack1:DiffUtil.ItemCallback<CharacterData>(){
        override fun areItemsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
            return oldItem.name == newItem.name
                    && oldItem.species == newItem.species
        }

    }

    /*class DiffUtilCallBack2:DiffUtil.ItemCallback<Info>(){
        override fun areItemsTheSame(oldItem: Info, newItem: Info): Boolean {
            return oldItem.count == newItem.count
        }

        override fun areContentsTheSame(oldItem:Info, newItem: Info): Boolean {
            return oldItem.pages == newItem.pages
                    && oldItem.count == newItem.count
        }

    }*/
}