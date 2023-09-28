package com.example.openai.ui.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.openai.databinding.ItemChatReciverBinding
import com.example.openai.databinding.ItemChatSenderBinding
import com.example.openai.domain.model.Message
import com.example.openai.ui.base.BaseAdapter
import com.example.openai.ui.base.BaseDiffUtil
import com.example.openai.ui.base.BaseViewHolder
import com.example.openai.utilites.RECEIVER
import com.example.openai.utilites.SENDER

class ChatAdapter (
    private var list: List<Message>,
) :BaseAdapter<Message>(list){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType){
            SENDER -> {
                val binding = ItemChatSenderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                SenderViewHolder(binding)
            }
            RECEIVER -> {
                val binding = ItemChatReciverBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ReceiverViewHolder(binding)
            }
            else -> {
                super.createViewHolder(parent,viewType)
            }
        }
    }


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
           when(holder){
              is SenderViewHolder -> holder.binding.item = list[position]
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


    private class SenderViewHolder (val binding: ItemChatSenderBinding): BaseViewHolder(binding)
    private class ReceiverViewHolder (val binding: ItemChatReciverBinding):BaseViewHolder(binding)




}


