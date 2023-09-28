package com.example.openai.ui.textClassification

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.openai.databinding.ItemChatReciverBinding
import com.example.openai.databinding.ItemChatSenderBinding
import com.example.openai.databinding.TextClassificationItemBinding
import com.example.openai.domain.model.Message
import com.example.openai.domain.model.TextClassification
import com.example.openai.ui.base.BaseAdapter
import com.example.openai.ui.base.BaseDiffUtil
import com.example.openai.ui.base.BaseViewHolder
import com.example.openai.utilites.RECEIVER
import com.example.openai.utilites.SENDER

class TextClassificationAdapter(
    private var list: List<TextClassification>,
) : BaseAdapter<TextClassification>(list) {

    private class TextClassificationViewHolder(val binding: TextClassificationItemBinding) : BaseViewHolder(binding)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = TextClassificationItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TextClassificationViewHolder(binding)
    }


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is TextClassificationViewHolder -> {
                holder.binding.item = list[position]
            }
        }
    }
}


