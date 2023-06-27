package com.dhananjay.testapplication.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dhananjay.testapplication.R
import com.dhananjay.testapplication.databinding.ItemListBinding
import com.dhananjay.testapplication.model.ListItem
import com.squareup.picasso.Picasso

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {
    var itemList = mutableListOf<ListItem>()
    private lateinit var binding: ItemListBinding

    fun setMovieList(itemList: List<ListItem>) {
        this.itemList = itemList.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
class MainViewHolder(private val bindingList:ItemListBinding) : RecyclerView.ViewHolder(bindingList.root) {
    fun bind(listItem: ListItem) {
        bindingList.listItem = listItem
    }
}

@BindingAdapter("urlImage")
fun bindUrlImage(view: ImageView, imageurl:String){
    Picasso.get().load(imageurl).into(view)
}