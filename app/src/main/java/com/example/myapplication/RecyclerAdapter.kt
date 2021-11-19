package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.graphics.translationMatrix
import androidx.recyclerview.widget.RecyclerView

import com.example.myapplication.Model


class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var words = Model().getHiddenWordList()

    //private var pickedWord: String? = null

    var pickedWord: List<String> = Model().pickAndSplit()
    //val word = (adapter as RecyclerAdapter).getPickedWord()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.hidden_word, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return pickedWord.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.activeWord.text = pickedWord[position]

    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var activeWord: TextView

        init {
            activeWord = itemView.findViewById(R.id.active_word)
        }

    }


}