package com.example.newreciclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newreciclerview.databinding.SingleItemBinding

class RvAdapter(var list: MutableList<User>): RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
      var binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
     var user = list[position]
        holder.binding.first.text = user.first
        holder.binding.last.text = user.last
        holder.binding.born.text = user.born.toString()
    }

    override fun getItemCount(): Int {
      return list.size
    }
fun aaa(list: MutableList<User>){
    this.list.clear()
    this.list.addAll(list)
    notifyDataSetChanged()
}
}

class UserViewHolder(var binding: SingleItemBinding): RecyclerView.ViewHolder(binding.root) {

}
