package com.example.myapplication

fun getHiddenWordList(): Array<String> {
    var words = arrayOf(
            "word",
            "bird",
            "nerd",
            "kurt",
            "introvert"
    )
    return words
}
class Model {

    fun getSpinValue(): String {
        var test = "test"

        return test
    }



    fun getHiddenWordList(): Array<String> {
        var words = arrayOf(
                "word",
                "bird",
                "nerd",
                "kurt",
                "introvert"
        )
        return words
    }

    fun pickAndSplit(): List<String> {
        var words = getHiddenWordList()

        val randomNumber = (0..words.size).random()
        var pickedWord = words[randomNumber]

        var chunked = pickedWord.chunked(1)


        return chunked
    }
}