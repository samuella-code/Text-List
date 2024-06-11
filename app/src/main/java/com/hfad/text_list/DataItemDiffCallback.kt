package com.hfad.text_list

import androidx.recyclerview.widget.DiffUtil


class DataItemDiffCallback : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        // Compare the unique IDs of the items
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        // Compare the contents of the items
        return oldItem == newItem
    }
}