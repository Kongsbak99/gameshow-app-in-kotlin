package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.graphics.translationMatrix
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var words = arrayOf(
        "word",
        "bird",
        "nerd",
        "kurt",
        "introvert"
    )
    private var pickedWord: String? = null

    /*private val hiddenWord: Array<CharArray>? = null

    fun pickWordAndSplit(){
        val randomNumber = (0..words.size).random()
        val pickedWord = words[randomNumber]


        print(pickedWord.toCharArray())
        print("nothingXXXXXXXXXXXXXX")
        print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
        print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")

    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.hidden_word, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val randomNumber = (0..words.size).random()

        pickedWord = words[randomNumber]

        holder.activeWord.text = pickedWord

    }

    fun getPickedWord(): String? {
        return pickedWord
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var activeWord: TextView

        init {
            activeWord = itemView.findViewById(R.id.active_word)
        }

    }


}