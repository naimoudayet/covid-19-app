package com.example.covid19app

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PrecautionsAdapter(var precautionsList: ArrayList<PrecautionsModel>) :
    RecyclerView.Adapter<PrecautionsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrecautionsAdapter.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        return ViewHolder(inflater, parent)

    }

    override fun getItemCount(): Int {
        return precautionsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val precautionsModel = precautionsList[position]

        holder.bind(precautionsModel)
    }

    class ViewHolder(inflater: LayoutInflater, viewGroup: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_precautions, viewGroup, false)) {

        fun bind(precautionsModel: PrecautionsModel) {
            val precautionsImageView = itemView.findViewById<ImageView>(R.id.ivPrecautions)
            val precautionsText = itemView.findViewById<TextView>(R.id.txtPrecautions)

            precautionsImageView.setImageResource(precautionsModel.imageView)
            precautionsText.text = precautionsModel.precautionsText
        }

    }
}