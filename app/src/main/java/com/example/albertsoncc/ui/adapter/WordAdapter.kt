package com.example.albertsoncc.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.albertsoncc.data.Lf
import com.example.albertsoncc.databinding.AcronymItemLayoutBinding

class WordAdapter(private var dataSet: List<Lf>): RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    fun updateList(newDataSet: List<Lf>){
        dataSet = newDataSet
        notifyDataSetChanged()
    }

    class WordViewHolder(private val binding: AcronymItemLayoutBinding):
        RecyclerView.ViewHolder(binding.root){
            fun onBind(acronymItem: Lf){
                binding.acronymItemFreq.text = acronymItem.freq.toString()
                binding.acronymItemLf.text = acronymItem.lf.toString()
                binding.acronymItemVars.text = acronymItem.vars.toString()
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        WordViewHolder(
            AcronymItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.onBind(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}