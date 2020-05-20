package com.example.covid19app

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Precautions2Adapter(var precautionsList: ArrayList<PrecautionsModel>) :
    RecyclerView.Adapter<Precautions2Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Precautions2Adapter.ViewHolder {

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
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_symptoms, viewGroup, false)) {

        fun bind(precautionsModel: PrecautionsModel) {
            val precautionsImageView = itemView.findViewById<ImageView>(R.id.ivSymptoms)
            val precautionsText = itemView.findViewById<TextView>(R.id.txtSymptoms)

            precautionsImageView.setImageResource(precautionsModel.imageView)
            precautionsText.text = precautionsModel.precautionsText
        }

    }
}