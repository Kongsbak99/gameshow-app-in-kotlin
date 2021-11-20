package com.example.myapplication

import android.content.res.Resources
import android.widget.TextView
import android.view.View
class Model {
    fun getSpinValue(): String {
        val randomNumber = (0..10).random()
        // 0-5 = ekstra points
        // 6-7 = miss turn
        // 8   = bankrupt
        // 9-10= extra life

        if (randomNumber == 8) {
            return "bankrupt"
        }else if (randomNumber == 6 || randomNumber == 7){
            return "spin again"
        }else if (randomNumber == 9 || randomNumber == 10){
            return "extra life"
        }else{
            return "1000 points"
        }
    }
    var category: String = "-"
    fun getRandomCategory(){
        val randomNumber = (1..4).random()
        if (randomNumber == 1){
            category = "Animals"
        }else if (randomNumber == 2){
            category = "Capitals"
        }else if (randomNumber == 3){
            category = "Wine Grapes"
        }else if (randomNumber == 4){
            category = "American Presidents"
        }
    }
    fun getHiddenWordList(): Array<String> {
        getRandomCategory()
        var words = arrayOf("")
        if (category == "Animals"){
            words = arrayOf(
                    "beaver",
                    "monkey",
                    "snake",
                    "crocodile",
                    "whale",
                    "wolf",
                    "rabbit"
            )
        }else if (category == "Capitals"){
            words = arrayOf(
                    "rome",
                    "copenhagen",
                    "london",
                    "madrid",
                    "kabul",
                    "stockholm",
                    "luxembourg"
            )
        }else if (category == "Wine Grapes"){
            words = arrayOf(
                    "chardonnay",
                    "zenit",
                    "malvasia",
                    "muscat",
                    "rebula",
                    "greco",
                    "gewurztraminer"
            )
        }else if (category == "American Presidents"){
            words = arrayOf(
                    "washington",
                    "jefferson",
                    "harrison",
                    "lincoln",
                    "roosevelt",
                    "truman",
                    "eisenhower",
                    "kennedy",
                    "bush",
                    "clinton",
                    "obama",
                    "trump",
                    "biden"
            )
        }
        return words
    }
    fun pickAndSplit(): List<String> {
        var words = getHiddenWordList()

        val randomNumber = (0..words.size).random()
        var pickedWord = words[randomNumber]

        var chunked: MutableList<String> = pickedWord.chunked(1) as MutableList<String>
        chunked.add(category)


        return chunked
    }
}