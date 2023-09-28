package com.example.openai.ui.image

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.openai.databinding.ItemChatSenderBinding
import com.example.openai.databinding.ItemImageReceiverBinding
import com.example.openai.databinding.ItemImageSenderBinding
import com.example.openai.domain.model.Image
import com.example.openai.ui.base.BaseAdapter
import com.example.openai.ui.base.BaseDiffUtil
import com.example.openai.ui.base.BaseViewHolder
import com.example.openai.utilites.RECEIVER
import com.example.openai.utilites.SENDER

class ImageGeneratorAdapter (
    private var list: List<Image>
) : BaseAdapter<Image>(list){


    private class SenderViewHolder (val binding: ItemImageSenderBinding): BaseViewHolder(binding)
    private class ReceiverViewHolder (val binding: ItemImageReceiverBinding):BaseViewHolder(binding)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        return when(viewType){
            SENDER -> {
                val binding = ItemImageSenderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return SenderViewHolder(binding)
            }

            RECEIVER -> {
                val binding = ItemImageReceiverBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ReceiverViewHolder(binding)
            }
            else -> {
                return super.createViewHolder(parent,viewType)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

        when(holder){
            is SenderViewHolder ->  holder.binding.item = list[position]
            is ReceiverViewHolder -> holder.binding.item = list[position]
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (list[position].sendBy == SENDER) {
            SENDER
        } else {
            RECEIVER
        }
    }

}