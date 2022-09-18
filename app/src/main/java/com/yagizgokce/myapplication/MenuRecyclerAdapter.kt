package com.yagizgokce.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yagizgokce.myapplication.databinding.RecyclerItemBinding

class MenuRecyclerAdapter(private val MarsList: List<MarsDataModel>,private val listener : Listener):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface Listener {
        fun onItemClick(marsDataModel: MarsDataModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MarsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MarsViewHolder).apply {
            itemView.setOnClickListener{
                listener.onItemClick(MarsList.get(position))
        }
            onBind(MarsList.get(position))
        }
    }

    override fun getItemCount(): Int {
        return MarsList.size
    }
}