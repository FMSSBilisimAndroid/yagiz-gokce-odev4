package com.yagizgokce.myapplication

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yagizgokce.myapplication.databinding.RecyclerItemBinding

class MarsViewHolder(val marsBinding: ViewDataBinding): RecyclerView.ViewHolder(marsBinding.root) {

    fun onBind(marsDataModel: MarsDataModel){
        val binding = marsBinding as RecyclerItemBinding
        binding.apply {
            textPrice.text ="${marsDataModel.price}${'$'}"
            textID.text ="ID: ${marsDataModel.id}"
            textType.text="${marsDataModel.type.uppercase()}"
        }
        Picasso.get().load(marsDataModel.img_src).into(binding.marsImage)
    }

}