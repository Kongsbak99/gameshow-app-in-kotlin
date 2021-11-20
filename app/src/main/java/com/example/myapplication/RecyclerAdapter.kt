package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.graphics.translationMatrix
import androidx.recyclerview.widget.RecyclerView

import com.example.myapplication.Model


class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var activeWord: TextView

        init {
            activeWord = itemView.findViewById(R.id.active_word)
        }

    }


    val pickedWord = Model().pickAndSplit()
    val category = pickedWord[pickedWord.size-1]


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.hidden_word, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return pickedWord.size - 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.activeWord.text = pickedWord[position]
    }



    /*fun getPickedWord(): List<String> {
        return pickedWord
    }*/





}