package com.dev.intourist.ui.screen.mytours.adapter

import android.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.dev.intourist.databinding.ItemMyTourBinding

class MyToursAdapter(
    private val list: List<MyTourModel>,
    private val onClick: () -> Unit,
    private val onDelete: (position:Int) -> Unit
) :
    RecyclerView.Adapter<MyToursViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyToursViewHolder {
        return MyToursViewHolder(
            ItemMyTourBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onDelete
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyToursViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            onClick()
        }
    }
}

class MyToursViewHolder(private val binding: ItemMyTourBinding, private val onDelete: (position:Int) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(myTourModel: MyTourModel) {
        binding.run {
            cancel.setOnClickListener {
                onDelete(adapterPosition)
            }
            tvTourTitle.text = myTourModel.title
            tvTourDate.text = myTourModel.date
            tvTourDuration.text = myTourModel.duration
            tvWhen.text = myTourModel.whenTour
            tvTourPrice.text = myTourModel.price
        }
    }
}
