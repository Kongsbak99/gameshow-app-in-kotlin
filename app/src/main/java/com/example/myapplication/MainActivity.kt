package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.RecyclerAdapter

class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    //val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    //val navController = navHostFragment.navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager

        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter




        print("")
    }

    fun onLetterClick(view: View) {        //TODO("Create function to check if letter is in word. ")
        val word = (adapter as RecyclerAdapter).getPickedWord() //hidden word user needs to guess
        var letter = view.getTag() //letter pressed by the user.
        print("")

        if (word != null) {
            for (i in word.indices){ //Loop through the hidden word letter by letter.
                var test = word[i]
                print("")
            }
        }else {
            print("Something went wrong when picking a random word. The picked word: ${word} , returned null")
            super.recreate()
        }
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