package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
class MainActivity : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var recyclerView: RecyclerView? = null
    private var adapter = RecyclerAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layoutManager = LinearLayoutManager(this)
        //Creating recycler val
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //setting recycler to horizontal scroll
        recyclerView!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        //Creating an arraylist of my data ( This is the hidden word, split up by each character )
        //adapter = RecyclerAdapter()
        recyclerView!!.adapter = adapter
        findViewById<TextView>(R.id.category).text = "Category: ${adapter.category}"
    }
    var spinValue = Model().getSpinValue()
    var spinable = true
    var totalPoints = 0
    var lives = 5
    var totalRightGuesses = 0
    fun spinTheWheel(view: View){
        spinValue = Model().getSpinValue()
        var wheelText = findViewById<TextView>(R.id.wheelText)
        if (spinable == true){
            if (spinValue == "bankrupt"){
                wheelText.text = "You went bankrupt. Spin again"
                totalPoints = 0
                var pointView = findViewById<TextView>(R.id.points)
                pointView.text = "Points: ${totalPoints}"
                spinable = true
            }else if(spinValue == "spin again"){
                wheelText.text = "You missed your turn and one life. Spin again."
                lives -= 1
                findViewById<TextView>(R.id.lives).text = "Lives: ${lives}"
                spinable = true
            }else if (spinValue == "extra life"){
                wheelText.text = "You gain an extra life!. Spin again!"
                lives += 1
                findViewById<TextView>(R.id.lives).text = "Lives: ${lives}"
                spinable = true
            }else{
                wheelText.text = "Guess a right letter, for 1000 points."
                spinable = false //This is the only case, where the player can guess and dont have to spin again.

            }
        }
    }
    fun onLetterClick(view: View) {
        val word = adapter.pickedWord//hidden word user needs to guess
        val letter = view.getTag().toString() //letter pressed by the user.
        var countRightGuesses = 0
        if (spinable == false) { //only guess letter, if the wheel has spun.
            if (word != null) {
                for (i in word.indices){ //Loop through the hidden word letter by letter.
                    var test = word[i]
                    print(test)
                    if(letter == word[i]){
                        countRightGuesses = countRightGuesses + 1
                        totalRightGuesses = totalRightGuesses + 1
                        onCorrectGuess(index = i)
                        if ((totalRightGuesses + 1) >= (word.size)){
                            goToWin(view)
                        }
                    }

                }
                if (countRightGuesses == 0){
                    lives -= 1
                    findViewById<TextView>(R.id.lives).text = "Lives: ${lives}"
                    if (lives == 0){
                        goToLose(view)
                    }
                }
                spinable = true
                findViewById<TextView>(R.id.wheelText).text = "Spin the wheel to guess again"
            }else {
                print("Something went wrong when picking a random word. The picked word: ${word} , returned null")
                super.recreate()
            }
        }
    }
    fun onCorrectGuess(index: Int){
        var pointView = findViewById<TextView>(R.id.points)
        totalPoints = totalPoints + 1000
        pointView.text = "Points: ${totalPoints}"
        recyclerView!!.getChildAt(index).setBackgroundColor(Color.WHITE)
    }
    // Navigation
    fun goToLose(view: View) {
        val action = GameStartFragmentDirections.actionGameStartFragmentToGameLoseFragment()
        view.findNavController().navigate(action)
    }
    fun goToWin(view: View) {
        val action = GameStartFragmentDirections.actionGameStartFragmentToGameWinFragment()
        view.findNavController().navigate(action)
    }
    fun restartWonGame(view: View) {
        val action = GameWinFragmentDirections.actionGameWinFragmentToGameStartFragment()
        view.findNavController().navigate(action)
        super.recreate()
    }
    fun restartLostGame(view: View) {
        val action = GameLoseFragmentDirections.actionGameLoseFragmentToGameStartFragment()
        view.findNavController().navigate(action)
        super.recreate()
    }
}