package com.example.hqapp_module15

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.hqapp_module15.placeholder.PlaceholderContent.PlaceholderItem
import com.example.hqapp_module15.databinding.FragmentItemBinding

interface HQItemListener{
    fun onItemSelected(position: Int)
}
class MyhqRecyclerViewAdapter(
    private val listener: HQItemListener
) : RecyclerView.Adapter<MyhqRecyclerViewAdapter.ViewHolder>() {

    private val values: MutableList<PlaceholderItem> = ArrayList()

    fun updateData(hqList: List<PlaceholderItem>){
        values.clear()
        values.addAll(hqList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.bindItem(item)

        holder.view.setOnClickListener{
            listener.onItemSelected(position)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(private val binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val view = binding.root
        fun bindItem(item: PlaceholderItem){
            binding.hqItem = item
            binding.executePendingBindings()
        }
    }

}