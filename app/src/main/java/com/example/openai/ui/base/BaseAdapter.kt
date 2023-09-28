package com.example.openai.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


abstract class BaseAdapter<T>(
    private var items: List<T>,
) : RecyclerView.Adapter<BaseViewHolder>() {

    open  fun setItems(newItems: List<T>) {
        val diffResult = DiffUtil.calculateDiff(BaseDiffUtil(items, newItems,::areItemsSame, ::areContentSame))
        items = newItems
        diffResult.dispatchUpdatesTo(this)
    }

    open fun areItemsSame(oldItem: T, newItem: T): Boolean {
        return oldItem?.equals(newItem) == true
    }
    open fun areContentSame(oldPosition: T, newPosition: T) = true
    override fun getItemCount() = items.size



}