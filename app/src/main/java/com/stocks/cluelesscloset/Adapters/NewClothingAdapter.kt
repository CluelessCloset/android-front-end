package com.stocks.cluelesscloset.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.stocks.cluelesscloset.POKO.ClothingData
import com.stocks.cluelesscloset.R


class NewClothingAdapter(private val dataList: MutableList<ClothingData>, val context: Context): RecyclerView.Adapter<NewClothingAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: NewClothingAdapter.ViewHolder?, position: Int) {
        Picasso.with(context)
                .load(dataList[position].imgUri)
                .placeholder(R.drawable.ic_clothes_dark)
                .error(R.drawable.ic_err)
                .into(holder?.image_icon)

        holder?.clothing_label?.text = dataList[position].clothingName
        holder?.trash_row?.setOnClickListener {
            removeItem(position)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent?.context)
                        .inflate(R.layout.new_clothing_row, parent, false))
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var image_icon: ImageView? = null
        var clothing_label: TextView? = null
        var trash_row: ImageView? = null
        init {
            image_icon = itemView?.findViewById(R.id.image_icon)
            clothing_label = itemView?.findViewById(R.id.clothing_label)
            trash_row = itemView?.findViewById(R.id.trash_row)
        }
    }

    private fun removeItem(position: Int) {
        dataList.removeAt(position)
        notifyItemRemoved(position)
    }
}