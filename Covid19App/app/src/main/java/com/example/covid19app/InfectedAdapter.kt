package com.example.covid19app

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class InfectedAdapter(var context: Context, var precautionsList: ArrayList<InfectedModel>) :
    RecyclerView.Adapter<InfectedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        return ViewHolder(inflater, parent)

    }

    override fun getItemCount(): Int {
        return precautionsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val infectedModel = precautionsList[position]

        holder.bind(infectedModel)
    }

    class ViewHolder(inflater: LayoutInflater, viewGroup: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_symptoms, viewGroup, false)) {

        fun bind(infectedModel: InfectedModel) {
            val flag = itemView.findViewById<ImageView>(R.id.ivSymptoms)
            val country = itemView.findViewById<TextView>(R.id.txtSymptoms)
            val cases = itemView.findViewById<TextView>(R.id.txtSymptomsDetail)

            if(infectedModel.flag != null){
                Glide.with(itemView.context).load(infectedModel.flag).into(flag)
            }

            country.text = infectedModel.country
            cases.text = infectedModel.cases
        }

    }
}